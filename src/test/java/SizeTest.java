import org.junit.Assert;
import org.junit.Test;

public class SizeTest {
    @Test
    public void should_override_equals(){
        Size size = new Size(100, 100);
        Assert.assertEquals(new Size(100,100), size);
    }
}
