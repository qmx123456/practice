public class Location {
    private int x;
    private int y;
    private char direction;

    public Location(int x, int y, char n) {
        this.x = x;
        this.y = y;
        direction = n;
    }

    @Override
    public boolean equals(Object obj) {
        Location ano = (Location) obj;
        return this.x == ano.getX() && this.y == ano.getY() && this.direction == ano.getDirection();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }

    public void forward(int i) {
        switch (direction) {
            case 'N':this.y += i;break;
            case 'S':this.y -=i;break;
            case 'E':this.x +=i;break;
            case 'W':this.x -=i;break;
        }
    }
}
