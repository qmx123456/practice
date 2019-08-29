import org.junit.Assert;
import org.junit.Test;

public class PointMarTest {
    @Test
    public void should_init_point(){
        PointMar pointMar = new PointMar(0, 0);
        Assert.assertEquals(0, pointMar.getX());
        Assert.assertEquals(0, pointMar.getY());

        pointMar.setX(1);
        pointMar.setY(2);
        Assert.assertEquals(1, pointMar.getX());
        Assert.assertEquals(2, pointMar.getY());
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
}
