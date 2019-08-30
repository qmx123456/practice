import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

public class TurnRightCommandTest {
    Mockery context = new JUnit4Mockery();

    @Test
    public void should_init_step(){
        TurnRightCommand command = new TurnRightCommand("2");
        Assert.assertEquals(2, command.getStep());
    }

    @Test
    public void should_change_location(){
        TurnRightCommand command = new TurnRightCommand("1");

        final IBehavior mock = context.mock(IBehavior.class);
        context.checking(new Expectations() {
            {
                oneOf(mock).turnRight(1);
                will(returnValue(true));
            }
        });
        Assert.assertEquals(true,command.run(mock));
    }

}
