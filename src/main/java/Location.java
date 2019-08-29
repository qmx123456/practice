public class Location implements IBehavior {
    private final String north = "N";
    private final String south = "S";
    private final String east = "E";
    private final String west = "W";
    private Direction direction;
    private IPoint pointMar;

    public Location() {
        pointMar = new PointMar();
    }

    public Location(int x, int y, String directionText) {
        pointMar = new PointMar(x, y);
        this.direction = DirectionFactory.build(directionText);
    }

    @Override
    public String toString(){
        return pointMar.toString()+","+ direction.getDirectionText();
    }

    @Override
    public boolean equals(Object obj) {
        Location ano = (Location) obj;
        return pointMar.equals(ano.getPoint()) && getDirection() == ano.getDirection();
    }

    public void back(int step) {
        switch (direction.getDirectionText()){
            case north:
                pointMar.addY(step*-1);
                break;
            case south:
                pointMar.addY(step);
                break;
            case east:
                pointMar.addX(step*-1);
                break;
            case west:
                pointMar.addX(step);
                break;
        }
    }

    public void forward(int step){
        switch (direction.getDirectionText()){
            case north:
                pointMar.addY(step);
                break;
            case south:
                pointMar.addY(step*-1);
                break;
            case east:
                pointMar.addX(step);
                break;
            case west:
                pointMar.addX(step*-1);
                break;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void set(Location ano) {
        pointMar.set(ano.getPoint());
        setDirection(ano.getDirection());
    }

    @Override
    public void setSize(Size size) {
        pointMar.setSize(size);
    }

    @Override
    public void turnLeft(int step) {
        direction = direction.turnLeft(step);
    }

    @Override
    public void turnRight(int step) {
        direction = direction.turnRight(step);
    }

    public IPoint getPoint() {
        return pointMar;
    }

    public void setPoint(IPoint point) {
        this.pointMar = point;
    }
}
