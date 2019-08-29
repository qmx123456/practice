public class South extends Direction {

    private static South direction;

    private South(){
        directionChar = "S";
    }
    @Override
    public Direction turnLeft(int step) {
        return null;
    }

    public static Direction build() {
        if (direction == null) {
            direction = new South();
        }
        return direction;
    }
}
