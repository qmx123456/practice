public class West extends Direction {

    private static West direction;

    private West(){
        directionChar = "W";
    }
    @Override
    public Direction turnLeft(int step) {
        return null;
    }

    public static Direction build() {
        if (direction == null) {
            direction = new West();
        }
        return direction;
    }
}
