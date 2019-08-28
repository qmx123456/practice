import org.junit.Assert;
import org.junit.Test;

public class LocationTest {
    @Test
    public void should_set_location() {
        Location location = new Location();
        location.setX(0);
        location.setY(0);
        location.setDirection("N");
        Assert.assertEquals(0, location.getX());
        Assert.assertEquals(0, location.getY());
        Assert.assertEquals("N", location.getDirection());

        Location ano = new Location(10, 10, "S");
        location.set(ano);
        Assert.assertEquals(ano, location);

    }

    @Test
    public void should_override_toString() {
        Location location = new Location(0, 0, "N");
        Assert.assertEquals("0,0,N", location.toString());
    }

    @Test
    public void should_override_equals() {
        Location location = new Location(0, 0, "N");
        Assert.assertEquals(new Location(0, 0, "N"), location);
    }


    @Test
    public void should_back() {
        Location carLocation = new Location(0, 0, "N");
        carLocation.back(1);
        Assert.assertEquals(new Location(0, -1, "N"), carLocation);

        carLocation = new Location(0, 0, "S");
        carLocation.back(1);
        Assert.assertEquals(new Location(0, 1, "S"), carLocation);

        carLocation = new Location(0, 0, "E");
        carLocation.back(1);
        Assert.assertEquals(new Location(-1, 0, "E"), carLocation);

        carLocation = new Location(0, 0, "W");
        carLocation.back(1);
        Assert.assertEquals(new Location(1, 0, "W"), carLocation);
    }

    @Test
    public void should_forward() {
        Location carLocation = new Location(0, 0, "N");
        carLocation.forward(1);
        Assert.assertEquals(new Location(0, 1, "N"), carLocation);

        carLocation = new Location(0, 0, "S");
        carLocation.forward(1);
        Assert.assertEquals(new Location(0, -1, "S"), carLocation);

        carLocation = new Location(0, 0, "E");
        carLocation.forward(1);
        Assert.assertEquals(new Location(1, 0, "E"), carLocation);

        carLocation = new Location(0, 0, "W");
        carLocation.forward(1);
        Assert.assertEquals(new Location(-1, 0, "W"), carLocation);
    }

}
