import org.junit.Assert;
import org.junit.Test;

public class WestTest {
    @Test
    public void should_turn_left() {
        Direction direction = West.build();
        Assert.assertEquals(South.build(), direction.turnLeft(1));

        Assert.assertEquals(East.build(), direction.turnLeft(2));

        Assert.assertEquals(North.build(), direction.turnLeft(3));
    }
    @Test
    public void should_turn_right() {
        Direction direction = West.build();
        Assert.assertEquals(North.build(), direction.turnRight(1));

        Assert.assertEquals(East.build(), direction.turnRight(2));

        Assert.assertEquals(South.build(), direction.turnRight(3));
    }
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
