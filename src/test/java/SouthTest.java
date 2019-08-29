import org.junit.Assert;
import org.junit.Test;

public class SouthTest {
    @Test
    public void should_turn_left() {
        Direction direction = South.build();
        Assert.assertEquals(East.build(), direction.turnLeft(1));

        direction = South.build();
        Assert.assertEquals(North.build(), direction.turnLeft(2));

        direction = South.build();
        Assert.assertEquals(West.build(), direction.turnLeft(3));
    }
    @Test
    public void should_turn_right() {
        Direction direction = South.build();
        Assert.assertEquals(West.build(), direction.turnRight(1));

        direction = South.build();;
        Assert.assertEquals(North.build(), direction.turnRight(2));

        direction = South.build();
        Assert.assertEquals(East.build(), direction.turnRight(3));
    }

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
