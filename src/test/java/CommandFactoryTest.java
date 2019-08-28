import org.junit.Assert;
import org.junit.Test;

public class CommandFactoryTest {
    @Test
    public void should_return_size_command(){
        Command command = CommandFactory.build("size:100,100");
        Assert.assertEquals(SizeCommand.class,command.getClass());
    }

    @Test
    public void should_return_location_command(){
        Command command = CommandFactory.build("location:0,0,N");
        Assert.assertEquals(LocationCommand.class,command.getClass());
    }
}
