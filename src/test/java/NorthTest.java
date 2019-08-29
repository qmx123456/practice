import org.junit.Assert;
import org.junit.Test;

public class NorthTest {
    @Test
    public void should_turn_left() {
        Direction direction = North.build();
        Assert.assertEquals(West.build(), direction.turnLeft(1));

        direction = North.build();;
        Assert.assertEquals(South.build(), direction.turnLeft(2));

        direction = North.build();
        Assert.assertEquals(East.build(), direction.turnLeft(3));
    }
    @Test
    public void should_turn_right() {
        Direction direction = North.build();
        Assert.assertEquals(East.build(), direction.turnRight(1));

        direction = North.build();;
        Assert.assertEquals(South.build(), direction.turnRight(2));

        direction = North.build();
        Assert.assertEquals(West.build(), direction.turnRight(3));
    }

    @Test
    public void should_get_unique_direction(){
        Direction one = North.build();
        Direction ano = North.build();
        Assert.assertEquals(one, ano);
    }

    @Test
    public void should_get_direction(){
        Direction one = North.build();
        Assert.assertEquals("N", one.getDirectionText());
    }

}
