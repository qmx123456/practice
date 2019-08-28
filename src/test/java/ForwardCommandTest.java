import org.junit.Assert;
import org.junit.Test;

public class ForwardCommandTest {
    @Test
    public void should_init_step(){
        ForwardCommand command = new ForwardCommand("1");
        Assert.assertEquals(1, command.getStep());
    }

    @Test
    public void should_change_location(){
        ForwardCommand command = new ForwardCommand("1");

        Location carLocation = new Location(0, 0, "N");
        command.run(carLocation);
        Assert.assertEquals(new Location(0,1,"N"), carLocation);
    }

}
