import org.junit.Assert;
import org.junit.Test;

public class LocationTest {
    @Test
    public void should_set_location(){
        Location location = new Location();
        location.setX(0);
        location.setY(0);
        location.setDirection("N");
        Assert.assertEquals(0, location.getX());
        Assert.assertEquals(0, location.getY());
        Assert.assertEquals("N", location.getDirection());
    }

    @Test
    public void should_override_toString(){
        Location location = new Location(0, 0, "N");
        Assert.assertEquals("0,0,N", location.toString());
    }

    @Test
    public void should_override_equals(){
        Location location = new Location(0, 0, "N");
        Assert.assertEquals(new Location(0,0,"N"), location);
    }

}
