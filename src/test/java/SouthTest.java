import org.junit.Assert;
import org.junit.Test;

public class SouthTest {

    @Test
    public void should_get_unique_direction(){
        Direction one = South.build();
        Direction ano = South.build();
        Assert.assertEquals(one, ano);
    }

    @Test
    public void should_get_direction(){
        Direction one = South.build();
        Assert.assertEquals("S", one.getDirectionText());
    }
}
