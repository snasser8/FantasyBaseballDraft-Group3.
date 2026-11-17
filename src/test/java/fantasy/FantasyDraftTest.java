package fantasy;

import org.junit.Test;
import static org.junit.Assert.assertThrows;

<<<<<<< HEAD
/** tests; behavior is not implemented yet. */
=======

/** Active stub invocation tests; business behavior is not implemented yet. */
>>>>>>> main
public class FantasyDraftTest {
    @Test
    public void parseCommandStubIsInvoked() {
        FantasyDraft app = new FantasyDraft();
        assertThrows(UnsupportedOperationException.class,
                () -> app.parseCommand("IDRAFT \"Sample Player\""));
    }

    @Test
    public void dispatchCommandStubIsInvoked() {
        FantasyDraft app = new FantasyDraft();
        assertThrows(UnsupportedOperationException.class,
                () -> app.dispatchCommand("TEAM A"));
    }

    @Test
    public void formatTeamStubIsInvoked() {
        FantasyDraft app = new FantasyDraft();
        assertThrows(UnsupportedOperationException.class,
                () -> app.formatTeam("A"));
    }
}
