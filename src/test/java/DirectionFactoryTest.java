import org.junit.Assert;
import org.junit.Test;

public class DirectionFactoryTest {

    @Test
    public void should_return_North(){
        Direction command = DirectionFactory.build("N");
        Assert.assertEquals(North.class,command.getClass());
    }
    @Test
    public void should_return_West(){
        Direction command = DirectionFactory.build("W");
        Assert.assertEquals(West.class,command.getClass());
    }
    @Test
    public void should_return_East(){
        Direction command = DirectionFactory.build("E");
        Assert.assertEquals(East.class,command.getClass());
    }

    @Test
    public void should_return_South(){
        Direction command = DirectionFactory.build("S");
        Assert.assertEquals(South.class,command.getClass());
    }
}
