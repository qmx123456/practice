import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

public class BackCommandTest {
    Mockery context = new JUnit4Mockery();

    @Test
    public void should_init_step(){
        BackCommand command = new BackCommand("1");
        Assert.assertEquals(1, command.getStep());
    }

    @Test
    public void should_change_location(){
        BackCommand command = new BackCommand("1");

        final IBehavior mock = context.mock(IBehavior.class);
        context.checking(new Expectations(){{
            oneOf(mock).back(1);
        }});
        command.run(mock);
    }

}
