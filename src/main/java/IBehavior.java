public interface IBehavior {
    boolean turnLeft(int step);
    boolean turnRight(int step);
    boolean forward(int step);
    boolean back(int step);
    boolean set(Location location);

    boolean setSize(Size size);
}
