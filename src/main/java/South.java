public class South extends Direction {

    private static South direction;

    private South(){
        directionChar = "S";
    }
    @Override
    public Direction turnLeft(int step) {
        int i = step % 4;
        switch (i) {
            case 1:
                return East.build();
            case 2:
                return North.build();
            case 3:
                return West.build();
        }
        return direction;
    }

    @Override
    public Direction turnRight(int step) {
        return null;
    }

    public static Direction build() {
        if (direction == null) {
            direction = new South();
        }
        return direction;
    }
}
