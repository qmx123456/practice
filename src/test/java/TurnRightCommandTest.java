import org.junit.Assert;
import org.junit.Test;

public class TurnRightCommandTest {
    @Test
    public void should_init_step(){
        TurnRightCommand command = new TurnRightCommand("2");
        Assert.assertEquals(2, command.getStep());
    }

    @Test
    public void should_change_location(){
        TurnRightCommand command = new TurnRightCommand("1");

        //mock
        Location carLocation = new Location(0, 0, "N");
        command.run(carLocation);
        Assert.assertEquals(new Location(0,0,"E"), carLocation);
    }

}
