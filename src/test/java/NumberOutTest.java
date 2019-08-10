import org.junit.Assert;
import org.junit.Test;

public class NumberOutTest {
    @Test
    public void should_out_1_when_num_is_1(){
        NumberOut numberOut = new NumberOut(1);
        Assert.assertEquals("1",numberOut.out());
    }
}
