import org.example.Main;
import org.example.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class maintest {

    Main game;

    @BeforeEach
    public void setUp() {
        game = new Main();
    }

    @Test
    public void testSwitchCurrentPlayerTogglesBetweenPlayers() {
        Player initial = game.currentPlayer;
        game.switchCurrentPlayer();
        assertNotEquals(initial, game.currentPlayer);
    }

    @Test
    public void testSwitchCurrentPlayerBackAndForth() {
        Player original = game.currentPlayer;
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals(original, game.currentPlayer);
    }

    @Test
    public void testHasWinnerForRow() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        game.currentPlayer = new Player('X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerReturnsFalseForEmptyBoard() {
        assertFalse(game.hasWinner());
    }
}