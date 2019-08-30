import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

public class TurnLeftCommandTest {

    Mockery context = new JUnit4Mockery();

    @Test
    public void should_init_step() {
        TurnLeftCommand command = new TurnLeftCommand("2");
        Assert.assertEquals(2, command.getStep());
    }

    @Test
    public void should_change_location() {
        TurnLeftCommand command = new TurnLeftCommand("1");
        final IBehavior mock = context.mock(IBehavior.class);
        context.checking(new Expectations() {
            {
                oneOf(mock).turnLeft(1);
                will(returnValue(true));
            }
        });
        Assert.assertEquals(true,command.run(mock));
    }

}
