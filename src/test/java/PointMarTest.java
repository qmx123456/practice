import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;

public class PointMarTest {
    private final JUnit4Mockery context = new JUnit4Mockery();
    IBlock mockBlock = context.mock(IBlock.class);

    @Test
    public void should_init_point(){
        PointMar pointMar = new PointMar(0, 0);
        Assert.assertEquals(0, pointMar.getX());
        Assert.assertEquals(0, pointMar.getY());

        pointMar.setX(1);
        pointMar.setY(2);
        Assert.assertEquals(1, pointMar.getX());
        Assert.assertEquals(2, pointMar.getY());

        Blocks blocks = new Blocks(new PointMar[]{});
        pointMar.setBlock(blocks);
        //todo assert blocks has been changed
    }

    @Test
    public void should_overide_equals(){
        PointMar pointMar = new PointMar(0, 0);
        PointMar ano = new PointMar(0, 0);
        Assert.assertEquals(ano, pointMar);
    }

    @Test
    public void should_overide_tostring(){
        PointMar pointMar = new PointMar(0, 0);
        Assert.assertEquals("0,0", pointMar.toString());
    }

    @Test
    public void should_in_size_when_size_is_decided(){
        PointMar point = new PointMar();
        point.setSize(new Size(10,10));
        point.set(new PointMar(11,0));
        Assert.assertEquals(new PointMar(0,0), point);

        point.setSize(new Size(10,10));
        point.set(new PointMar(-1,0));
        Assert.assertEquals(new PointMar(10,0), point);

        point.setSize(new Size(10,10));
        point.set(new PointMar(0,11));
        Assert.assertEquals(new PointMar(0,0), point);

        point.setSize(new Size(10,10));
        point.set(new PointMar(0,-1));
        Assert.assertEquals(new PointMar(0,10), point);
    }

    @Test
    public void should_addY_when_not_block(){
        PointMar pointMar = new PointMar(0,0);
        context.checking(new Expectations(){{
            oneOf(mockBlock).isBlocked(0, 1);
            will(returnValue(false));
        }});
        pointMar.setBlock(mockBlock);
        boolean res = pointMar.addY(1);
        Assert.assertEquals(1, pointMar.getY());
        Assert.assertEquals(true, res);

        pointMar = new PointMar(0,0);
        context.checking(new Expectations(){{
            oneOf(mockBlock).isBlocked(0, -1);
            will(returnValue(false));
        }});
        pointMar.setBlock(mockBlock);
        res = pointMar.addY(-1);
        Assert.assertEquals(-1, pointMar.getY());
        Assert.assertEquals(true, res);
    }

    @Test
    public void should_addY_when_block(){
        PointMar pointMar = new PointMar(0,0);
        context.checking(new Expectations(){{
            oneOf(mockBlock).isBlocked(0, 1);
            will(returnValue(true));
        }});
        pointMar.setBlock(mockBlock);
        boolean res = pointMar.addY(1);
        Assert.assertEquals(0, pointMar.getY());
        Assert.assertEquals(false, res);

        pointMar = new PointMar(0,0);
        context.checking(new Expectations(){{
            oneOf(mockBlock).isBlocked(0, -1);
            will(returnValue(true));
        }});
        pointMar.setBlock(mockBlock);
        res = pointMar.addY(-1);
        Assert.assertEquals(0, pointMar.getY());
        Assert.assertEquals(false, res);
    }

    @Test
    public void should_addX_when_not_block(){
        PointMar pointMar = new PointMar(0,0);
        context.checking(new Expectations(){{
            oneOf(mockBlock).isBlocked(1, 0);
            will(returnValue(false));
        }});
        pointMar.setBlock(mockBlock);
        boolean res = pointMar.addX(1);
        Assert.assertEquals(1, pointMar.getX());
        Assert.assertEquals(true, res);

        pointMar = new PointMar(0,0);
        context.checking(new Expectations(){{
            oneOf(mockBlock).isBlocked(-1, 0);
            will(returnValue(false));
        }});
        pointMar.setBlock(mockBlock);
        pointMar.addX(-1);
        Assert.assertEquals(-1, pointMar.getX());
        Assert.assertEquals(true, res);
    }

    @Test
    public void should_addX_when_block(){
        PointMar pointMar = new PointMar(0,0);
        context.checking(new Expectations(){{
            oneOf(mockBlock).isBlocked(1, 0);
            will(returnValue(true));
        }});
        pointMar.setBlock(mockBlock);
        boolean res = pointMar.addX(1);
        Assert.assertEquals(0, pointMar.getX());
        Assert.assertEquals(false, res);

        pointMar = new PointMar(0,0);
        context.checking(new Expectations(){{
            oneOf(mockBlock).isBlocked(-1, 0);
            will(returnValue(true));
        }});
        pointMar.setBlock(mockBlock);
        res = pointMar.addX(-1);
        Assert.assertEquals(0, pointMar.getX());
        Assert.assertEquals(false, res);
    }
}
