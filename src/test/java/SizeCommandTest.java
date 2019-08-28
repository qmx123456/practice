import org.junit.Assert;
import org.junit.Test;

public class SizeCommandTest {
    @Test
    public void should_init_size(){
        SizeCommand command = new SizeCommand("100,100");
        Assert.assertEquals(100, command.getX());
        Assert.assertEquals(100, command.getY());
    }
}
