import org.junit.Assert;
import org.junit.Test;

public class WestTest {

    @Test
    public void should_get_unique_direction(){
        Direction one = West.build();
        Direction ano = West.build();
        Assert.assertEquals(one, ano);
    }

    @Test
    public void should_get_direction(){
        Direction one = West.build();
        Assert.assertEquals("W", one.getDirectionText());
    }

}
