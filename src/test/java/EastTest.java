import org.junit.Assert;
import org.junit.Test;

public class EastTest {
    @Test
    public void should_turn_left() {
        Direction direction = East.build();
        Assert.assertEquals(North.build(), direction.turnLeft(1));

        direction = East.build();
        Assert.assertEquals(West.build(), direction.turnLeft(2));

        direction = East.build();
        Assert.assertEquals(South.build(), direction.turnLeft(3));
    }
    @Test
    public void should_turn_right() {
        Direction direction = East.build();
        Assert.assertEquals(South.build(), direction.turnRight(1));

        Assert.assertEquals(West.build(), direction.turnRight(2));

        Assert.assertEquals(North.build(), direction.turnRight(3));
    }

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
