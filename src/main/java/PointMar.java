public class PointMar implements IPoint {
    private int x;
    private int y;
    private Size size;
    private IBlock blocks;

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
    public void setBlock(IBlock blocks) {
        this.blocks = blocks;
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        PointMar ano = (PointMar) obj;
        return x == ano.getX() && y == ano.getY();
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    @Override
    public boolean addY(int step) {
        if (isBlock(step, y, x)) return false;
        this.y += step;
        return true;
    }

    private boolean isBlock(int step, int y, int x) {
        int match= step>0 ?1 :-1;
        for (int i = 1; i <= step * match; i++) {
            if (blocks.isBlocked(x, y + i * match)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBlockX(int step, int y, int x) {
        int match= step>0 ?1 :-1;
        for (int i = 1; i <= step * match; i++) {
            if (blocks.isBlocked(x+ i * match, y )) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addX(int step) {
        if (isBlockX(step, y, x)) return false;
        this.x += step;
        return true;
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
        if (source > max) {
            ano = source - max - 1;
        }
        if (source < 0) {
            ano = max + source + 1;
        }
        return ano;
    }
}
