import org.junit.Assert;
import org.junit.Test;

public class BackCommandTest {
    @Test
    public void should_init_step(){
        BackCommand command = new BackCommand("1");
        Assert.assertEquals(1, command.getStep());
    }

    @Test
    public void should_change_location(){
        BackCommand command = new BackCommand("1");

        Location carLocation = new Location(0, 0, "N");
        command.run(carLocation);
        Assert.assertEquals(new Location(0,-1,"N"), carLocation);
    }

}
