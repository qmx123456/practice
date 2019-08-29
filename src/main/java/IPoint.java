public interface IPoint {
    void set(IPoint point);

    void setY(int y);

    void setX(int x);

    boolean addY(int i);

    boolean addX(int i);

    void setSize(Size size);

    int getX();

    int getY();

    void setBlock(Blocks blocks);
}
