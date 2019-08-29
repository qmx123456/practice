public class North extends Direction {

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

    public static Direction build() {
        if (direction == null) {
            direction = new North();
        }
        return direction;
    }
}
