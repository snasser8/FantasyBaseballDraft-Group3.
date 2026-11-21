
package fantasy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.junit.Test;

/** Tests IDRAFT, ODRAFT, duplicate picks, and roster integration. */
public class DraftIntegrationTest {

    @Test
    public void commandLoopRunsBothDraftCommands() {
        FantasyDraft application = new FantasyDraft(Map.of(
                "Cole, Gerrit", new BigDecimal("209.0")));

        application.registerAvailablePlayer(
                new Player("RF", "Judge, Aaron"));

        String commands = "IDRAFT \"Judge, A\"\n"
                + "ODRAFT \"Cole, G\" B\n"
                + "TEAM A\nTEAM B\nPOVERALL\nQUIT\n";

        ByteArrayOutputStream capturedOutput =
                new ByteArrayOutputStream();

        application.run(
                new ByteArrayInputStream(
                        commands.getBytes(StandardCharsets.UTF_8)),
                new PrintStream(capturedOutput));

        String output =
                capturedOutput.toString(StandardCharsets.UTF_8);

        assertTrue(output.contains("Judge, Aaron"));
        assertTrue(output.contains("Cole, Gerrit"));
        assertTrue(output.contains("No available pitchers."));
    }

    @Test
    public void idraftUpdatesTeamA() {
        FantasyDraft application = new FantasyDraft();

        application.registerAvailablePlayer(
                new Player("RF", "Judge, Aaron"));

        assertTrue(application.dispatchCommand(
                "idraft \"judge, a\"").contains("team A"));

        assertTrue(application.dispatchCommand(
                "TEAM A").contains("Judge, Aaron"));

        assertEquals("Team B\nNo players drafted.",
                application.dispatchCommand("TEAM B"));
    }

    @Test
    public void odraftUpdatesOpponentAndRejectsDuplicatePick() {
        FantasyDraft application = new FantasyDraft();

        application.registerAvailablePlayer(
                new Player("RF", "Judge, Aaron"));

        assertTrue(application.dispatchCommand(
                "ODRAFT \"Judge\" B").contains("team B"));

        assertTrue(application.dispatchCommand(
                "IDRAFT \"Judge, Aaron\"")
                .contains("already drafted"));

        assertTrue(application.dispatchCommand(
                "TEAM B").contains("Judge, Aaron"));

        assertFalse(application.dispatchCommand(
                "TEAM A").contains("Judge, Aaron"));
    }

    @Test
    public void draftedPitcherIsRemovedFromRanking() {
        FantasyDraft application = new FantasyDraft(Map.of(
                "Cole, Gerrit", new BigDecimal("209.0"),
                "Gausman, Kevin", new BigDecimal("185.0")));

        assertTrue(application.dispatchCommand(
                "POVERALL").contains("Cole, Gerrit"));

        assertTrue(application.dispatchCommand(
                "ODRAFT \"Cole, G\" C").contains("team C"));

        assertTrue(application.dispatchCommand(
                "TEAM C").contains("Cole, Gerrit"));

        assertFalse(application.dispatchCommand(
                "POVERALL").contains("Cole, Gerrit"));

        assertTrue(application.dispatchCommand(
                "POVERALL").contains("Gausman, Kevin"));
    }

    @Test
    public void ambiguousNamesAndUnknownPlayersDoNotDraft() {
        FantasyDraft application = new FantasyDraft();

        application.registerAvailablePlayer(
                new Player("RF", "Martinez, Jose"));

        application.registerAvailablePlayer(
                new Player("1B", "Martinez, Jairo"));

        assertTrue(application.dispatchCommand(
                "IDRAFT \"Martinez\"").contains("Ambiguous"));

        assertTrue(application.dispatchCommand(
                "IDRAFT \"Unknown\"").contains("No player found"));

        assertEquals("Team A\nNo players drafted.",
                application.dispatchCommand("TEAM A"));

        assertTrue(application.dispatchCommand(
                "IDRAFT \"Martinez, Jos\"").contains("team A"));
    }

    @Test
    public void occupiedSlotAndInvalidCommandsAreRejected() {
        FantasyDraft application = new FantasyDraft();

        application.registerAvailablePlayer(
                new Player("RF", "Judge, Aaron"));

        application.registerAvailablePlayer(
                new Player("RF", "Tucker, Kyle"));

        assertTrue(application.dispatchCommand(
                "IDRAFT \"Judge\"").contains("team A"));

        assertTrue(application.dispatchCommand(
                "IDRAFT \"Tucker\"").contains("roster slot"));

        assertTrue(application.dispatchCommand(
                "ODRAFT \"Tucker\" Z").contains("Invalid team"));

        assertTrue(application.dispatchCommand(
                "IDRAFT").contains("Usage"));

        assertEquals("Team B\nNo players drafted.",
                application.dispatchCommand("TEAM B"));
    }

    @Test
    public void matchesAccentedNamesAndPreventsDuplicatePicks() {
        FantasyDraft application = new FantasyDraft();

        application.registerAvailablePlayer(
                new Player("SS", "Báez*, Javier"));

        assertTrue(application.dispatchCommand(
                "IDRAFT \"Baez, J\"").contains("team A"));

        assertTrue(application.dispatchCommand(
                "ODRAFT \"Báez, Javier\" D")
                .contains("already drafted"));

        assertTrue(application.dispatchCommand(
                "TEAM A").contains("Javier"));
    }

    @Test
    public void recordedPicksAppearInTeamDisplay() {
        FantasyDraft application = new FantasyDraft();

        application.recordPick("Judge, Aaron", "B");

        assertTrue(application.dispatchCommand(
                "TEAM B").contains("Judge, Aaron"));

        assertFalse(application.dispatchCommand(
                "TEAM A").contains("Judge, Aaron"));
    }

    @Test
    public void matchesFirstLastNamesAndSuffixes() {
        FantasyDraft application = new FantasyDraft();

        application.registerAvailablePlayer(
                new Player("RF", "Aaron Judge"));

        application.registerAvailablePlayer(
                new Player("CF", "Luis Robert Jr."));

        assertTrue(application.dispatchCommand(
                "IDRAFT \"Judge, A\"").contains("team A"));

        assertTrue(application.dispatchCommand(
                "ODRAFT \"Robert Jr, L\" B").contains("team B"));
    }

    @Test
    public void pitchersAreNumberedInDraftOrderAndCappedAtFive() {
        Draft draft = new Draft();

        for (int number = 1; number <= 5; number++) {
            assertTrue(draft.draftPlayer(
                    "Pitcher " + number, "A", "P"));
        }

        assertFalse(draft.draftPlayer(
                "Sixth Pitcher", "A", "P"));

        assertTrue(draft.getRoster("A")
                .contains("P5: Pitcher 5"));

        assertFalse(draft.isDrafted("Sixth Pitcher"));
    }
}
