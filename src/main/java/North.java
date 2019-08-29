public class North implements Direction {
    String directionChar;
    private static North direction;
    private North(){
        directionChar = "N";
    }
    @Override
    public Direction turnLeft(int step) {
        int i = step % 4;
        switch (i) {
            case 1:
                return West.build();
            case 2:
                return South.build();
            case 3:
                return East.build();
        }
        return direction;
    }
    @Override
    public Direction turnRight(int step) {
        int i = step % 4;
        switch (i) {
            case 1:
                return East.build();
            case 2:
                return South.build();
            case 3:
                return West.build();
        }
        return direction;

    }
    public static Direction build() {
        if (direction == null) {
            direction = new North();
        }
        return direction;
    }

    public String getDirectionText() {
        return directionChar;
    }
}

