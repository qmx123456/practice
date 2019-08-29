public class West implements Direction {
    String directionChar;

    private static West direction;

    private West(){
        directionChar = "W";
    }
    @Override
    public Direction turnLeft(int step) {
        int i = step % 4;
        switch (i) {
            case 1:
                return South.build();
            case 2:
                return East.build();
            case 3:
                return North.build();
        }
        return direction;
    }

    @Override
    public Direction turnRight(int step) {
        return null;
    }

    public static Direction build() {
        if (direction == null) {
            direction = new West();
        }
        return direction;
    }

    public String getDirectionText() {
        return directionChar;
    }
}
