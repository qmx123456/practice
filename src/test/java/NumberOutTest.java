import org.junit.Assert;
import org.junit.Test;

public class NumberOutTest {
    @Test
    public void should_out_1_when_num_is_1(){
        NumberOut numberOut = new NumberOut(1);
        Assert.assertEquals("1",numberOut.out());
    }

    @Test
    public void should_out_Fizz_when_num_is_divisible_by_3(){
        NumberOut numberOut = new NumberOut(3);
        Assert.assertEquals("Fizz", numberOut.out());
    }
}
