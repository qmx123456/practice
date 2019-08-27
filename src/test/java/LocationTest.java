import org.junit.Assert;
import org.junit.Test;

public class LocationTest {
    @Test
    public void should_overide_equal(){
        Location location = new Location(0, 0, 'N');
        Location anotherLocation = new Location(0, 0, 'N');

        Assert.assertEquals(location, anotherLocation);
    }

    @Test
    public void should_forward(){
        Location location = new Location(0, 0, 'N');
        location.forward(1);
        Assert.assertEquals(new Location(0, 1, 'N'), location);

        location = new Location(0, 0, 'S');
        location.forward(1);
        Assert.assertEquals(new Location(0, -1, 'S'), location);

        location = new Location(0, 0, 'E');
        location.forward(1);
        Assert.assertEquals(new Location(1, 0, 'E'), location);

        location = new Location(0, 0, 'W');
        location.forward(1);
        Assert.assertEquals(new Location(-1, 0, 'W'), location);
    }

    @Test
    public void should_back(){
        Location location = new Location(0, 0, 'N');
        location.back(1);
        Assert.assertEquals(new Location(0, -1, 'N'), location);

        location = new Location(0, 0, 'S');
        location.back(1);
        Assert.assertEquals(new Location(0, 1, 'S'), location);

        location = new Location(0, 0, 'E');
        location.back(1);
        Assert.assertEquals(new Location(-1, 0, 'E'), location);

        location = new Location(0, 0, 'W');
        location.back(1);
        Assert.assertEquals(new Location(1, 0, 'W'), location);
    }
}
