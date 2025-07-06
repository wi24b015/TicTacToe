import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Board;

import static org.junit.jupiter.api.Assertions.*;


class boardTest {

    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testIsCellEmptyReturnsTrueInitially() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmptyReturnsFalseAfterPlacement() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testPlaceOnlySetsEmptyCell() {
        board.place(1, 1, 'X');
        board.place(1, 1, 'O');
        assertEquals('X', board.getCell(1, 1));
    }

    @Test
    public void testBoardIsFullReturnsTrueWhenAllCellsFilled() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testBoardIsFullReturnsFalseWhenNotAllCellsFilled() {
        board.place(0, 0, 'X');
        assertFalse(board.isFull());
    }

    @Test
    public void testClearResetsAllCells() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testGetCellReturnsCorrectMarker() {
        board.place(2, 2, 'O');
        assertEquals('O', board.getCell(2, 2));
    }

    @Test
    public void testGetCellReturnsEmptyForUnplacedCell() {
        assertEquals(' ', board.getCell(1, 1));
    }
}
