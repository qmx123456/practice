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

        marCar.location(0, 0, 'N');
        marCar.forward(1);
        location = marCar.getLocation();
        Assert.assertEquals(new Location(0, 1, 'N'), location);

        marCar.location(0, 0, 'N');
        marCar.back(1);
        location = marCar.getLocation();
        Assert.assertEquals(new Location(0, -1, 'N'), location);
    }
}
