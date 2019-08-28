import org.junit.Assert;
import org.junit.Test;

public class MarCarTest {
    @Test
    public void should_return_location_and_direction(){
        MarCar marCar = new MarCar();
        String location = marCar.run("size:100,100 location:0,0,N");
        Assert.assertEquals("0,0,N", location);
    }
}
