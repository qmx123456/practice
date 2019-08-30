import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

public class LocationTest {
    private final JUnit4Mockery context = new JUnit4Mockery();
    final IPoint mockPoint = context.mock(IPoint.class);

    @Test
    public void should_set_location() {
        Location location = new Location(0,0,"N");
        Assert.assertEquals(new PointMar(0,0), location.getPoint());
        Assert.assertEquals(North.build(), location.getDirection());

        final Blocks blocks = new Blocks(new PointMar[]{});
        final Size size = new Size(100, 100);
        final Location ano = new Location(11, 0, "N");
        context.checking(new Expectations(){{
            oneOf(mockPoint).set(ano.getPoint());
            oneOf(mockPoint).setSize(size);
            oneOf(mockPoint).setBlock(blocks);
        }});

        location.setBlocks(blocks);
        location.setPoint(mockPoint);
        boolean resultSetSize = location.setSize(size);
        boolean resSetLocation = location.set(ano);
        Assert.assertEquals(true, resultSetSize);
        Assert.assertEquals(true, resSetLocation);
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
    public void should_back_when_north() {
        Location carLocation = new Location(0, 0, "N");
        context.checking(new Expectations(){{
            oneOf(mockPoint).addY(-1);
            will(returnValue(true));
        }});
        carLocation.setPoint(mockPoint);
        boolean res = carLocation.back(1);
        Assert.assertEquals(true, res);
    }

    @Test
    public void should_back_when_south() {
        Location carLocation = new Location(0, 0, "S");
        context.checking(new Expectations(){{
            oneOf(mockPoint).addY(1);
            will(returnValue(true));
        }});
        carLocation.setPoint(mockPoint);
        boolean res = carLocation.back(1);
        Assert.assertEquals(true, res);
    }

    @Test
    public void should_back_when_east() {
        Location carLocation = new Location(0, 0, "E");
        context.checking(new Expectations(){{
            oneOf(mockPoint).addX(-1);
            will(returnValue(true));
        }});
        carLocation.setPoint(mockPoint);
        boolean res = carLocation.back(1);
        Assert.assertEquals(true, res);
    }

    @Test
    public void should_back_when_west() {
        Location carLocation = new Location(0, 0, "W");
        context.checking(new Expectations(){{
            oneOf(mockPoint).addX(1);
            will(returnValue(true));
        }});
        carLocation.setPoint(mockPoint);
        boolean res = carLocation.back(1);
        Assert.assertEquals(true, res);
    }

    @Test
    public void should_forward_when_north() {
        Location carLocation = new Location(0, 0, "N");
        context.checking(new Expectations(){{
            oneOf(mockPoint).addY(1);
            will(returnValue(true));
        }});
        carLocation.setPoint(mockPoint);
        boolean res = carLocation.forward(1);
        Assert.assertEquals(true, res);
    }

    @Test
    public void should_forward_when_south() {
        Location carLocation = new Location(0, 0, "S");
        context.checking(new Expectations(){{
            oneOf(mockPoint).addY(-1);
            will(returnValue(true));
        }});
        carLocation.setPoint(mockPoint);
        boolean res = carLocation.forward(1);
        Assert.assertEquals(true, res);
    }

    @Test
    public void should_forward_when_east() {
        Location carLocation = new Location(0, 0, "E");
        context.checking(new Expectations(){{
            oneOf(mockPoint).addX(1);
            will(returnValue(true));
        }});
        carLocation.setPoint(mockPoint);
        boolean res = carLocation.forward(1);
        Assert.assertEquals(true, res);
    }
    @Test
    public void should_forward_when_west() {
        Location carLocation = new Location(0, 0, "W");
        context.checking(new Expectations(){{
            oneOf(mockPoint).addX(-1);
            will(returnValue(true));
        }});
        carLocation.setPoint(mockPoint);
        boolean res = carLocation.forward(1);
        Assert.assertEquals(true, res);
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
