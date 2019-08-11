import org.junit.Assert;
import org.junit.Test;

public class NumberOutTest {
    @Test
    public void should_out_1_when_num_is_1(){
        assertOut(1, "1");
    }


    @Test
    public void should_out_Fizz_when_num_is_divisible_by_3(){
        assertOut(3, "Fizz");
    }

    @Test
    public void should_out_Buzz_when_num_is_divisible_by_5(){
        assertOut(5, "Buzz");
    }

    private void assertOut(int i, String s) {
        NumberOut numberOut = new NumberOut(i);
        Assert.assertEquals(s, numberOut.out());
    }
}
