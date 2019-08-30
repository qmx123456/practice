import org.junit.Assert;
import org.junit.Test;

public class BlocksTest {
    @Test
    public void should_return_true_when_block(){
        Blocks blocks = new Blocks(new PointMar[]{new PointMar(1, 1)});
        Assert.assertEquals(true, blocks.isBlocked(1,1));
        Assert.assertEquals(false, blocks.isBlocked(0,1));
    }
}
