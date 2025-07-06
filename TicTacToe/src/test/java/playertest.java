import org.example.Player;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class playertest {

    @Test
    public void testGetMarkerReturnsCorrectValue() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());

    }

    @Test
    public void testDifferentMarker() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
    }
}
