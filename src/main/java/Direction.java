public interface Direction {
    Direction turnLeft(int step);

    String getDirectionText();

    Direction turnRight(int step);
}
