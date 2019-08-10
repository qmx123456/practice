import org.junit.Assert;
import org.junit.Test;

public class NumberOutTest {
    @Test
    public void should_out_1_when_num_is_1(){
        assertOut("1", 1);
    }

    @Test
    public void should_out_Fizz_when_num_is_divisible_by_3(){
        assertOut("Fizz", 3);
    }

    @Test
    public void should_out_Buzz_when_num_is_divisible_by_5(){
        assertOut("Buzz", 5);
    }
    private void assertOut(String expectOut, int num) {
        NumberOut numberOut = new NumberOut(num);
        Assert.assertEquals(expectOut, numberOut.out());
    }
}
