import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

public class LocationCommandTest {
    private final JUnit4Mockery context = new JUnit4Mockery();
    @Test
    public void should_init_size(){
        LocationCommand command = new LocationCommand("0,0,N");
        Assert.assertEquals(new Location(0,0,"N"), command.getLocation());
    }

    @Test
    public void should_change_location(){
        final LocationCommand command = new LocationCommand("0,0,N");
        final IBehavior mock = context.mock(IBehavior.class);
        context.checking(new Expectations(){{
            oneOf(mock).set(command.getLocation());
            will(returnValue(true));
        }});
        Assert.assertEquals(true, command.run(mock));
    }
}
