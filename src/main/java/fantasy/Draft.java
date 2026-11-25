package fantasy;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

/** Records picks for four fantasy teams and prevents duplicate selections. */
public class Draft {
    private static final Set<String> VALID_TEAMS = Set.of("A", "B", "C", "D");

    private final Map<String, Team> teams = new LinkedHashMap<>();
    private final Set<String> draftedPlayers = new HashSet<>();

    public Draft() {
        for (String teamId : VALID_TEAMS) {
            teams.put(teamId, new Team());
        }
    }

    // Draft a known player to one team and position.
    public boolean draftPlayer(String playerName, String teamId, String position) {
        if (playerName == null || playerName.isBlank() || teamId == null) {
            return false;
        }
        Team team = teams.get(teamId.strip().toUpperCase(Locale.ROOT));
        String playerKey = normalizeName(playerName);
        if (team == null || draftedPlayers.contains(playerKey)) {
            return false;
        }
        if (!team.addPlayer(playerName, position)) {
            return false;
        }
        draftedPlayers.add(playerKey);
        return true;
    }

    // Check every team for an existing pick.
    public boolean isDrafted(String playerName) {
        return playerName != null && draftedPlayers.contains(normalizeName(playerName));
    }

    // Get a team's roster, or an empty string if its ID is invalid.
    public String getRoster(String teamId) {
        if (teamId == null) {
            return "";
        }
        Team team = teams.get(teamId.strip().toUpperCase(Locale.ROOT));
        return team == null ? "" : team.getRoster();
    }

    public int getPitcherCount(String teamId) {
        if (teamId == null) {
            return 0;
        }
        Team team = teams.get(teamId.strip().toUpperCase(Locale.ROOT));
        return team == null ? 0 : team.getPitcherCount();
    }

    // Resolve a name before recording an IDRAFT or ODRAFT selection.
    public String draftByName(String playerQuery, String teamId, Collection<Player> playerCatalog,
                              BiConsumer<String, String> recordPick) {
        return draftByName(playerQuery, teamId, playerCatalog, name -> false, recordPick);
    }

    public String draftByName(String playerQuery, String teamId, Collection<Player> playerCatalog,
                              Predicate<String> previouslyPicked,
                              BiConsumer<String, String> recordPick) {
        String normalizedTeam = teamId == null ? "" : teamId.strip().toUpperCase(Locale.ROOT);
        if (!VALID_TEAMS.contains(normalizedTeam)) {
            return "Invalid team. Use A, B, C, or D. No player drafted.";
        }
        List<Player> matches = findMatchingPlayers(playerQuery, playerCatalog);
        if (matches.isEmpty()) {
            return "No player found for '" + playerQuery + "'. No player drafted.";
        }
        if (matches.size() > 1) {
            return "Ambiguous player name '" + playerQuery + "'. No player drafted.";
        }
        Player player = matches.get(0);
        if (isDrafted(player.getName()) || previouslyPicked.test(player.getName())) {
            return player.getName() + " is already drafted. No player drafted.";
        }
        if (!draftPlayer(player.getName(), normalizedTeam, player.getPosition())) {
            return "Team " + normalizedTeam + " has no available "
                    + player.getPosition() + " roster slot. No player drafted.";
        }
        recordPick.accept(player.getName(), normalizedTeam);
        return player.getName() + " has been drafted to team " + normalizedTeam + ".";
    }

    // Normalize names for case, accent, and special-character differences.
    static String normalizeName(String playerName) {
        String withoutAccents = Normalizer.normalize(playerName, Normalizer.Form.NFD)
                .replaceAll("\\p{M}+", "");
        return withoutAccents.toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9, ]", "")
                .replaceAll("\\s+", " ").strip();
    }

    private List<Player> findMatchingPlayers(String query, Collection<Player> playerCatalog) {
        List<Player> matches = new ArrayList<>();
        if (query == null || query.isBlank() || playerCatalog == null) {
            return matches;
        }
        for (Player player : playerCatalog) {
            if (matchesName(query, player.getName())) {
                matches.add(player);
            }
        }
        return matches;
    }

    private boolean matchesName(String query, String playerName) {
        String requested = normalizeName(query);
        String[] playerParts = nameParts(playerName);
        String[] queryParts = requested.split(",", 2);
        if (queryParts.length == 2) {
            String requestedFirstName = queryParts[1].strip();
            return playerParts[0].equals(queryParts[0].strip())
                    && !requestedFirstName.isEmpty()
                    && playerParts[1].startsWith(requestedFirstName);
        }
        return requested.equals(playerParts[0])
                || requested.equals(playerParts[1] + " " + playerParts[0]);
    }

    private String[] nameParts(String playerName) {
        String normalized = normalizeName(playerName);
        String[] commaParts = normalized.split(",", 2);
        if (commaParts.length == 2) {
            return new String[] { commaParts[0].strip(), commaParts[1].strip() };
        }
        String[] words = normalized.split(" ");
        if (words.length < 2) {
            return new String[] { normalized, "" };
        }
        int lastNameWords = Set.of("jr", "sr", "ii", "iii").contains(words[words.length - 1])
                && words.length > 2 ? 2 : 1;
        String firstName = String.join(" ", List.of(words).subList(0, words.length - lastNameWords));
        String lastName = String.join(" ", List.of(words).subList(words.length - lastNameWords,
                words.length));
        return new String[] { lastName, firstName };
    }
}
