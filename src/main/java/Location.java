public class Location {
    private final String north = "N";
    private final String south = "S";
    private final String east = "E";
    private final String west = "W";
    private int x;
    private int y;
    private Direction direction;

    public Location() {
    }

    public Location(int x, int y, String directionText) {
        this.x = x;
        this.y = y;
        this.direction = DirectionFactory.build(directionText);
    }

    @Override
    public String toString(){
        return x+","+y+","+ direction.getDirectionText();
    }

    @Override
    public boolean equals(Object obj){
        Location ano = (Location) obj;
        return x == ano.getX() &&y==ano.getY() && direction == ano.getDirection();
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void back(int step) {
        switch (direction.getDirectionText()){
            case north:setY(y-step);break;
            case south:setY(y+step);break;
            case east:setX(x-step);break;
            case west:setX(x+step);break;
        }
    }

    public void forward(int step){
        switch (direction.getDirectionText()){
            case north:setY(y+step);break;
            case south:setY(y-step);break;
            case east:setX(x+step);break;
            case west:setX(x-step);break;
        }
    }

    public void set(Location ano) {
        setX(ano.getX());
        setY(ano.getY());
        setDirection(ano.getDirection());
    }

    public void turnLeft(int step) {
        direction = direction.turnLeft(step);
    }

    public void turnRight(int step) {
        direction = direction.turnRight(step);
    }
}
