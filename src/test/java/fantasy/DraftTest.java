package fantasy;

import org.junit.Test;
import static org.junit.Assert.*;

// Joseph Bean - JUnit tests
public class DraftTest {

    // Test drafting a player
    @Test
    public void testDraftPlayer() {
        Draft draft = new Draft();

        boolean result = draft.draftPlayer("Judge, Aaron", "A", "RF");
        String roster = draft.getRoster("A");

        assertTrue(result);
        assertTrue(roster.contains("Judge"));
    }

    // Test duplicate picks
    @Test
    public void testIsDrafted() {
        Draft draft = new Draft();

        boolean first = draft.draftPlayer("Judge, Aaron", "A", "RF");
        boolean drafted = draft.isDrafted("Judge, Aaron");
        boolean second = draft.draftPlayer("Judge, Aaron", "B", "RF");

        assertTrue(first);
        assertTrue(drafted);
        assertFalse(second);
    }

    // Test occupied roster positions
    @Test
    public void testRosterSlot() {
        Team team = new Team();

        boolean first = team.addPlayer("Judge, Aaron", "RF");
        boolean second = team.addPlayer("Tucker, Kyle", "RF");
        String roster = team.getRoster();

        assertTrue(first);
        assertFalse(second);
        assertTrue(roster.contains("Judge"));
    }
}