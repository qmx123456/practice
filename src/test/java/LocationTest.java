import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

public class LocationTest {
    private final JUnit4Mockery context = new JUnit4Mockery();
    @Test
    public void should_set_location() {
        Location location = new Location(0,0,"N");
        Assert.assertEquals(new PointMar(0,0), location.getPoint());
        Assert.assertEquals(North.build(), location.getDirection());

        final Size size = new Size(100, 100);
        final Location ano = new Location(11, 0, "N");
        final IPoint mock = context.mock(IPoint.class);
        context.checking(new Expectations(){{
            oneOf(mock).set(ano.getPoint());
            oneOf(mock).setSize(size);
        }});

        location.setPoint(mock);
        location.setSize(size);
        location.set(ano);
        Assert.assertEquals(North.build(), location.getDirection());
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
