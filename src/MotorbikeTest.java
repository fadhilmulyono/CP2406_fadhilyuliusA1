import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MotorbikeTest {
    Motorbike motorbike = new Motorbike("0");

    @Test
    void getLength(){
        assertEquals(0.5, motorbike.getLength());
    }

    @Test
    void getId(){
        assertEquals("bike_0", motorbike.getId());
    }

    @Test
    void testInheritance(){
        assertEquals(0, motorbike.getSpeed());
        assertEquals(1, motorbike.getPosition());
    }
}
