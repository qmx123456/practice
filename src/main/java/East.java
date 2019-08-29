public class East extends Direction {

    private static East direction;

    private East(){
        directionChar = "E";
    }
    @Override
    public Direction turnLeft(int step) {
        return null;
    }

    public static Direction build() {
        if (direction == null) {
            direction = new East();
        }
        return direction;
    }
}
