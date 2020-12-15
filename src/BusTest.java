import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BusTest {
    Bus bus = new Bus("0");

    @Test
    void getLength(){
        assertEquals(3, bus.getLength());
    }

    @Test
    void getId(){
        assertEquals("bus_0", bus.getId());
    }

    @Test
    void testInheritance(){
        assertEquals(0, bus.getSpeed());
        assertEquals(1, bus.getPosition());
    }
}
