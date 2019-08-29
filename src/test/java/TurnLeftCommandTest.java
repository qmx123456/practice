import org.junit.Assert;
import org.junit.Test;

public class TurnLeftCommandTest {
    @Test
    public void should_init_step(){
        TurnLeftCommand command = new TurnLeftCommand("2");
        Assert.assertEquals(2, command.getStep());
    }

    @Test
    public void should_change_location(){
        TurnLeftCommand command = new TurnLeftCommand("1");

        Location carLocation = new Location(0, 0, "N");
        command.run(carLocation);
        Assert.assertEquals(new Location(0,0,"W"), carLocation);
    }

}
