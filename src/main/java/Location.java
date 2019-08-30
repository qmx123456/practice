public class Location implements IBehavior {
    private final String north = "N";
    private final String south = "S";
    private final String east = "E";
    private final String west = "W";
    private Direction direction;
    private IPoint pointMar;
    private Blocks blocks;

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

    public boolean back(int step) {
        switch (direction.getDirectionText()){
            case north:
                return pointMar.addY(step*-1);
            case south:
                return pointMar.addY(step);
            case east:
                return pointMar.addX(step*-1);
            case west:
                return pointMar.addX(step);
        }
        return false;
    }

    @Override
    public boolean forward(int step){
        switch (direction.getDirectionText()){
            case north:
                return pointMar.addY(step);
            case south:
                return pointMar.addY(step*-1);
            case east:
                return pointMar.addX(step);
            case west:
                return pointMar.addX(step*-1);
        }
        return false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean set(Location ano) {
        pointMar.set(ano.getPoint());
        setDirection(ano.getDirection());
        return true;
    }

    @Override
    public boolean setSize(Size size) {
        pointMar.setSize(size);
        return true;
    }

    @Override
    public boolean turnLeft(int step) {
        direction = direction.turnLeft(step);
        return true;
    }

    @Override
    public boolean turnRight(int step) {
        direction = direction.turnRight(step);
        return true;
    }

    public IPoint getPoint() {
        return pointMar;
    }

    public void setPoint(IPoint point) {
        this.pointMar = point;
    }

    public void setBlocks(Blocks blocks) {
        pointMar.setBlock(blocks);
    }
}
