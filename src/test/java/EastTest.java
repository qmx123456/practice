import org.junit.Assert;
import org.junit.Test;

public class EastTest {

    @Test
    public void should_get_unique_direction(){
        Direction one = East.build();
        Direction ano = East.build();
        Assert.assertEquals(one, ano);
    }

    @Test
    public void should_get_direction(){
        Direction one = East.build();
        Assert.assertEquals("E", one.getDirectionText());
    }

}
