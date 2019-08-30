public class Blocks implements IBlock{
    private PointMar[] points;

    public Blocks(PointMar[] points) {
        this.points = points;
    }

    @Override
    public boolean isBlocked(int x, int y) {
        for (int i =0;i<points.length;i++){
            if (points[i].getY() == y && points[i].getX() == x){
                return true;
            }
        }
        return false;
    }
}
