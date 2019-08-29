import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

public class ForwardCommandTest {
    private final JUnit4Mockery context = new JUnit4Mockery();
    @Test
    public void should_init_step(){
        ForwardCommand command = new ForwardCommand("1");
        Assert.assertEquals(1, command.getStep());
    }

    @Test
    public void should_change_location(){
        ForwardCommand command = new ForwardCommand("1");


        final IBehavior mock = context.mock(IBehavior.class);
        context.checking(new Expectations(){{
            oneOf(mock).forward(1);
        }});
        command.run(mock);
    }

}
