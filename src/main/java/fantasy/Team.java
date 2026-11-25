package fantasy;

import java.util.*;

/** A fantasy team with eight fielders and up to five pitchers. */
public class Team {
    private static final List<String> FIELD_POSITIONS = List.of(
            "C", "1B", "2B", "3B", "SS", "LF", "CF", "RF");
    private static final int MAX_PITCHERS = 5;

    private final Map<String, String> fielders = new LinkedHashMap<>();
    private final List<String> pitchers = new ArrayList<>();

    // Adds a player only when the roster has room.
    public boolean addPlayer(String playerName, String position) {
        if (playerName == null || playerName.isBlank() || position == null) {
            return false;
        }
        String rosterPosition = position.strip().toUpperCase(Locale.ROOT);
        if (containsPlayer(playerName)) {
            return false;
        }
        if (rosterPosition.equals("P")) {
            if (pitchers.size() == MAX_PITCHERS) {
                return false;
            }
            pitchers.add(playerName.strip());
            return true;
        }
        if (!FIELD_POSITIONS.contains(rosterPosition) || fielders.containsKey(rosterPosition)) {
            return false;
        }
        fielders.put(rosterPosition, playerName.strip());
        return true;
    }

    // Shows fielders in position order, followed by pitchers in draft order.
    public String getRoster() {
        List<String> rosterLines = new ArrayList<>();
        for (String position : FIELD_POSITIONS) {
            if (fielders.containsKey(position)) {
                rosterLines.add(position + ": " + fielders.get(position));
            }
        }
        for (int pitcherNumber = 0; pitcherNumber < pitchers.size(); pitcherNumber++) {
            rosterLines.add("P" + (pitcherNumber + 1) + ": " + pitchers.get(pitcherNumber));
        }
        return String.join("\n", rosterLines);
    }

    public int getPitcherCount() {
        return pitchers.size();
    }

    private boolean containsPlayer(String playerName) {
        String requestedName = Draft.normalizeName(playerName);
        for (String existingName : fielders.values()) {
            if (Draft.normalizeName(existingName).equals(requestedName)) {
                return true;
            }
        }
        for (String existingName : pitchers) {
            if (Draft.normalizeName(existingName).equals(requestedName)) {
                return true;
            }
        }
        return false;
    }
}
