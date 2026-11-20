package fantasy;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FantasyDraft {
    private static final Pattern TOKEN = Pattern.compile("\\G\\s*(?:\"([^\"]*)\"|([^\\s\"]+))(?=\\s|$)");

    private final Map<String, BigDecimal> pitchers;
    private final Map<String, String> draftedTeams = new LinkedHashMap<>();
    private final Map<String, Function<List<String>, String>> draftCommands = new HashMap<>();

    public FantasyDraft() {
        this(Map.of());
    }

    public FantasyDraft(Map<String, BigDecimal> pitchers) {
        this.pitchers = Map.copyOf(pitchers);
    }

    public List<String> parseCommand(String input) {
        Matcher matcher = TOKEN.matcher(input.strip());
        List<String> tokens = new ArrayList<>();
        int end = 0;
        while (matcher.find()) {
            tokens.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
            end = matcher.end();
        }
        if (end != input.strip().length()) {
            throw new IllegalArgumentException("Use matching quotes around multi-word arguments.");
        }
        return tokens;
    }

    /** Connects a teammate's implementation of OVERALL, IDRAFT, or ODRAFT. */
    public void registerDraftCommand(String command, Function<List<String>, String> handler) {
        draftCommands.put(command.toUpperCase(Locale.ROOT), handler);
    }

    /** Records a successful pick for TEAM and removes it from the available rankings. */
    public void recordPick(String playerName, String teamId) {
        if (draftedTeams.putIfAbsent(playerName, teamKey(teamId)) != null) {
            throw new IllegalArgumentException(playerName + " is already drafted.");
        }
    }

    public String dispatchCommand(String input) {
        try {
            List<String> tokens = parseCommand(input);
            if (tokens.isEmpty()) {
                return "";
            }
            String command = tokens.get(0).toUpperCase(Locale.ROOT);
            return switch (command) {
                case "POVERALL" -> tokens.size() == 1 ? formatPitchers() : "Usage: POVERALL";
                case "TEAM" -> tokens.size() == 2 ? formatTeam(tokens.get(1)) : "Usage: TEAM <team>";
                case "OVERALL", "IDRAFT", "ODRAFT" -> runDraftCommand(command, tokens);
                case "QUIT" -> tokens.size() == 1 ? "" : "Usage: QUIT";
                default -> "Unknown command: " + tokens.get(0);
            };
        } catch (IllegalArgumentException error) {
            return error.getMessage();
        }
    }

    private String runDraftCommand(String command, List<String> tokens) {
        Function<List<String>, String> handler = draftCommands.get(command);
        if (handler == null) {
            return command + " is not configured.";
        }
        return handler.apply(tokens.subList(1, tokens.size()));
    }

    public String formatTeam(String teamId) {
        String team = teamKey(teamId);
        String roster = draftedTeams.entrySet().stream()
                .filter(pick -> pick.getValue().equals(team))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining("\n"));
        return "Team " + team + "\n" + (roster.isEmpty() ? "No players drafted." : roster);
    }

    private static String teamKey(String teamId) {
        if (teamId.isBlank()) {
            throw new IllegalArgumentException("Enter a team identifier.");
        }
        return teamId.strip().toUpperCase(Locale.ROOT);
    }

    private String formatPitchers() {
        String ranking = pitchers.entrySet().stream()
                .filter(pitcher -> !draftedTeams.containsKey(pitcher.getKey()))
                .sorted(Map.Entry.<String, BigDecimal>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(pitcher -> pitcher.getKey() + "\t" + pitcher.getValue().toPlainString())
                .collect(Collectors.joining("\n"));
        return ranking.isEmpty() ? "No available pitchers." : "Pitcher\tIP\n" + ranking;
    }

    public void run(InputStream input, PrintStream output) {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().strip();
            if (line.equalsIgnoreCase("QUIT")) {
                return;
            }
            String response = dispatchCommand(line);
            if (!response.isEmpty()) {
                output.println(response);
            }
        }
    }

    public static void main(String[] args) {
        new FantasyDraft().run(System.in, System.out);
    }
}
