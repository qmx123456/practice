import org.junit.Assert;
import org.junit.Test;

public class LocationCommandTest {
    @Test
    public void should_init_size(){
        LocationCommand command = new LocationCommand("0,0,N");
        Assert.assertEquals(new Location(0,0,"N"), command.getLocation());
    }

    @Test
    public void should_change_location(){
        LocationCommand command = new LocationCommand("0,0,N");
        Location carLocation = new Location(1, 1, "N");
        command.run(carLocation);
        Assert.assertEquals(new Location(0,0,"N"), carLocation);
    }
}
