public class East implements Direction {
    String directionChar;

    private static East direction;

    private East(){
        directionChar = "E";
    }
    @Override
    public Direction turnLeft(int step) {
        int i = step % 4;
        switch (i) {
            case 1:
                return North.build();
            case 2:
                return West.build();
            case 3:
                return South.build();
        }
        return direction;
    }

    @Override
    public Direction turnRight(int step) {
        return null;
    }

    public static Direction build() {
        if (direction == null) {
            direction = new East();
        }
        return direction;
    }

    public String getDirectionText() {
        return directionChar;
    }
}
