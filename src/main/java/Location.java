public class Location {
    private int x;
    private int y;
    private String direction;

    public Location() {
    }

    public Location(int x, int y, String direction) {

        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString(){
        return x+","+y+","+direction;
    }

    @Override
    public boolean equals(Object obj){
        Location ano = (Location) obj;
        return x == ano.getX() &&y==ano.getY()&&direction.equals(ano.getDirection());
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void back(int step) {
        switch (direction){
            case "N":setY(y-step);break;
            case "S":setY(y+step);break;
            case "E":setX(x-step);break;
            case "W":setX(x+step);break;
        }
    }

    public void forward(int step){
        switch (direction){
            case "N":setY(y+step);break;
            case "S":setY(y-step);break;
            case "E":setX(x+step);break;
            case "W":setX(x-step);break;
        }
    }

    public void set(Location ano) {
        setX(ano.getX());
        setY(ano.getY());
        setDirection(ano.getDirection());
    }
}
