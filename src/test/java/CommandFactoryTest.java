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

    @Test
    public void should_return_forward_command(){
        Command command = CommandFactory.build("f:1");
        Assert.assertEquals(ForwardCommand.class,command.getClass());
    }

    @Test
    public void should_return_back_command(){
        Command command = CommandFactory.build("b:1");
        Assert.assertEquals(BackCommand.class,command.getClass());
    }

    @Test
    public void should_return_left_command(){
        Command command = CommandFactory.build("l:2");
        Assert.assertEquals(TurnLeftCommand.class,command.getClass());
    }

    @Test
    public void should_return_right_command(){
        Command command = CommandFactory.build("r:2");
        Assert.assertEquals(TurnRightCommand.class,command.getClass());
    }
}
