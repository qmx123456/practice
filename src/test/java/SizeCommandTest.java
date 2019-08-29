import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

public class SizeCommandTest {
    private final JUnit4Mockery context = new JUnit4Mockery();
    @Test
    public void should_init_size(){
        final SizeCommand command = new SizeCommand("100,100");
        Assert.assertEquals(new Size(100, 100), command.getSize());

        final IBehavior mock = context.mock(IBehavior.class);
        context.checking(new Expectations(){{
            oneOf(mock).setSize(command.getSize());
        }});
        command.run(mock);
    }
}
