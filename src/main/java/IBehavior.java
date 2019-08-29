public interface IBehavior {
    void turnLeft(int step);
    void turnRight(int step);
    boolean forward(int step);
    void back(int step);
    boolean set(Location location);

    boolean setSize(Size size);
}
