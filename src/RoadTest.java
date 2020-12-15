import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class RoadTest {
    Road road = new Road("0", 1, 5, new int[]{0, 0});

    @Test
    void getId(){
        assertEquals("road_0", road.getId());
    }

    @Test
    void getSpeedLimit(){
        assertEquals(1, road.getSpeedLimit());
    }

    @Test
    void getLength(){
        assertEquals(5, road.getLength());
    }

    @Test
    void getStartLocation(){
        int[] expectedStart = {0,0};
        assertArrayEquals(expectedStart, road.getStartLocation());
    }

    @Test
    void getEndLocation(){
        int[] expectedEnd = {5,0};
        assertArrayEquals(expectedEnd, road.getEndLocation());
    }

    @Test
    void getCarsOnRoad(){
        ArrayList<Car> expectedCars = new ArrayList<>();
        assertEquals(expectedCars, road.getCarsOnRoad());
    }

    @Test
    void getLightsOnRoad(){
        ArrayList<TrafficLight> expectedLights = new ArrayList<>();
        assertEquals(expectedLights, road.getLightsOnRoad());
    }

    @Test
    void getConnectedRoads(){
        ArrayList<Road> expectedRoads = new ArrayList<>();
        assertEquals(expectedRoads, road.getConnectedRoads());
    }
}
