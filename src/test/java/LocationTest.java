import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

public class LocationTest {
    private final JUnit4Mockery context = new JUnit4Mockery();
    @Test
    public void should_set_location() {
        Location location = new Location();
        location.setX(0);
        location.setY(0);
        location.setDirection(North.build());
        location.setSize(new Size(100,100));
        Assert.assertEquals(0, location.getX());
        Assert.assertEquals(0, location.getY());
        Assert.assertEquals(North.build(), location.getDirection());
        Assert.assertEquals(new Size(100,100), location.getSize());

        Location ano = new Location(10, 10, "S");
        location.set(ano);
        Assert.assertEquals(ano, location);
    }

    @Test
    public void should_in_size_when_size_is_decided(){
        Location location = new Location();

        location.setSize(new Size(10,10));
        location.set(new Location(11,0,"N"));
        Assert.assertEquals(new Location(0,0,"N"), location);

        location.setSize(new Size(10,10));
        location.set(new Location(-1,0,"N"));
        Assert.assertEquals(new Location(10,0,"N"), location);

        location.setSize(new Size(10,10));
        location.set(new Location(0,11,"N"));
        Assert.assertEquals(new Location(0,0,"N"), location);

        location.setSize(new Size(10,10));
        location.set(new Location(0,-1,"N"));
        Assert.assertEquals(new Location(0,10,"N"), location);
    }



    @Test
    public void should_override_toString() {
        Location location = new Location(0, 0, "N");
        Assert.assertEquals("0,0,N", location.toString());
    }

    @Test
    public void should_override_equals() {
        Location location = new Location(0, 0, "N");
        Assert.assertEquals(new Location(0, 0, "N"), location);
    }

    @Test
    public void should_back() {
        Location carLocation = new Location(0, 0, "N");
        carLocation.back(1);
        Assert.assertEquals(new Location(0, -1, "N"), carLocation);

        carLocation = new Location(0, 0, "S");
        carLocation.back(1);
        Assert.assertEquals(new Location(0, 1, "S"), carLocation);

        carLocation = new Location(0, 0, "E");
        carLocation.back(1);
        Assert.assertEquals(new Location(-1, 0, "E"), carLocation);

        carLocation = new Location(0, 0, "W");
        carLocation.back(1);
        Assert.assertEquals(new Location(1, 0, "W"), carLocation);
    }

    @Test
    public void should_forward() {
        Location carLocation = new Location(0, 0, "N");
        carLocation.forward(1);
        Assert.assertEquals(new Location(0, 1, "N"), carLocation);

        carLocation = new Location(0, 0, "S");
        carLocation.forward(1);
        Assert.assertEquals(new Location(0, -1, "S"), carLocation);

        carLocation = new Location(0, 0, "E");
        carLocation.forward(1);
        Assert.assertEquals(new Location(1, 0, "E"), carLocation);

        carLocation = new Location(0, 0, "W");
        carLocation.forward(1);
        Assert.assertEquals(new Location(-1, 0, "W"), carLocation);
    }

    @Test
    public void should_turn_left() {
        Location carLocation = new Location(0, 0, "N");
        final Direction mock = context.mock(Direction.class);
        context.checking(new Expectations(){{
            oneOf(mock).turnLeft(1);
            will(returnValue(West.build()));
        }});
        carLocation.setDirection(mock);
        carLocation.turnLeft(1);
        Assert.assertEquals(new Location(0, 0, "W"), carLocation);
    }

    @Test
    public void should_turn_right() {
        Location carLocation = new Location(0, 0, "N");
        final Direction mock = context.mock(Direction.class);
        context.checking(new Expectations(){{
            oneOf(mock).turnRight(1);
            will(returnValue(East.build()));
        }});
        carLocation.setDirection(mock);
        carLocation.turnRight(1);
        Assert.assertEquals(new Location(0, 0, "E"), carLocation);
    }

}
