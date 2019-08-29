public interface IBehavior {
    void turnLeft(int step);
    void turnRight(int step);
    void forward(int step);
    void back(int step);
    void set(Location location);
}
