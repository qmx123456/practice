public class PointMar implements IPoint {
    private int x;
    private int y;
    private Size size;

    public PointMar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PointMar() {
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        PointMar ano = (PointMar) obj;
        return x == ano.getX() && y == ano.getY();
    }

    @Override
    public String toString(){
        return x +","+ y;
    }

    @Override
    public void addY(int step) {
        this.y += step;
    }

    @Override
    public void addX(int step) {
        this.x += step;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public void set(IPoint point) {
        setX(matchWithSize(size.getX(), point.getX()));
        setY(matchWithSize(size.getY(), point.getY()));
    }

    private int matchWithSize(int max, int source) {
        int ano = source;
        if (source > max){
            ano = source - max -1;
        }
        if (source < 0){
            ano = max+source+1;
        }
        return ano;
    }
}
