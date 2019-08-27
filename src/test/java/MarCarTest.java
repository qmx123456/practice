import org.junit.Assert;
import org.junit.Test;

public class MarCarTest {
    @Test
    public void should_return_location_and_direction(){
        MarCar marCar = new MarCar();
        marCar.set(100,100);
        marCar.location(0, 0, 'N');

        Location location = marCar.getLocation();
        Assert.assertEquals(new Location(0, 0, 'N'), location);
    }
}
