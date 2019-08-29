public abstract class Direction {
    String directionChar;

    public abstract Direction turnLeft(int step);

    public String getDirectionText() {
        return directionChar;
    }

    public abstract Direction turnRight(int step);
}
