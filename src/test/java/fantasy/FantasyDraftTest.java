package fantasy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FantasyDraftTest {
    @Test
    public void parsesQuotedArgumentsAndRejectsUnclosedQuotes() {
        FantasyDraft app = new FantasyDraft();
        assertEquals(List.of("IDRAFT", "Sample Player"), app.parseCommand(" IDRAFT  \"Sample Player\" "));
        assertThrows(IllegalArgumentException.class, () -> app.parseCommand("IDRAFT \"Sample Player"));
    }

    @Test
    public void pitcherRankingUsesDescendingIpAndExcludesDraftedPlayers() {
        FantasyDraft app = new FantasyDraft(Map.of(
                "Low IP", new BigDecimal("9.2"),
                "Middle IP", new BigDecimal("10.0"),
                "High IP", new BigDecimal("100.1")));
        assertEquals("Pitcher\tIP\nHigh IP\t100.1\nMiddle IP\t10.0\nLow IP\t9.2",
                app.dispatchCommand("poverall"));

        app.recordPick("High IP", "B");
        assertEquals("Pitcher\tIP\nMiddle IP\t10.0\nLow IP\t9.2", app.dispatchCommand("POVERALL"));
    }

    @Test
    public void teamShowsOnlyThatTeamsPicksInDraftOrder() {
        FantasyDraft app = new FantasyDraft();
        app.recordPick("First Player", "a");
        app.recordPick("Other Player", "B");
        app.recordPick("Second Player", "A");
        assertEquals("Team A\nFirst Player\nSecond Player", app.dispatchCommand("team a"));
        assertEquals("Team C\nNo players drafted.", app.formatTeam("C"));
    }

    @Test
    public void commandLoopDispatchesPicksAndRosterQueriesUntilQuit() {
        FantasyDraft app = new FantasyDraft();
        app.registerDraftCommand("IDRAFT", args -> {
            app.recordPick(args.get(0), "A");
            return "Drafted " + args.get(0);
        });

        String commands = "TEAM\nIDRAFT \"Sample Player\"\nTEAM A\nquit\nTEAM B\n";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        app.run(new ByteArrayInputStream(commands.getBytes(StandardCharsets.UTF_8)),
                new PrintStream(output, true, StandardCharsets.UTF_8));

        assertEquals(List.of("Usage: TEAM <team>", "Drafted Sample Player", "Team A", "Sample Player"),
                output.toString(StandardCharsets.UTF_8).lines().toList());
    }
}
