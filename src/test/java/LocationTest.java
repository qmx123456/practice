import org.junit.Assert;
import org.junit.Test;

public class LocationTest {
    @Test
    public void should_overide_equal(){
        Location location = new Location(0, 0, 'n');
        Location anotherLocation = new Location(0, 0, 'n');

        Assert.assertEquals(location, anotherLocation);
    }
}
