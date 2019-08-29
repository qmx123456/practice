import org.junit.Assert;
import org.junit.Test;

public class MarCarTest {
    @Test
    public void should_return_location_and_direction(){
        MarCar marCar = new MarCar();
        String location = marCar.run("size:100,100 location:0,0,N");
        Assert.assertEquals("0,0,N", location);
    }

    @Test
    public void should_chan_location_after_forward(){
        MarCar marCar = new MarCar();
        String location = marCar.run("size:100,100 location:0,0,N f:1");
        Assert.assertEquals("0,1,N", location);
    }

    @Test
    public void should_change_location_after_back(){
        MarCar marCar = new MarCar();
        String location = marCar.run("size:100,100 location:0,0,N b:1");
        Assert.assertEquals("0,-1,N", location);
    }

    @Test
    public void should_change_direction_after_turn_left(){
        MarCar marCar = new MarCar();
        String location = marCar.run("size:100,100 location:0,0,N l:2");
        Assert.assertEquals("0,0,S", location);
    }
}
