public class Size  {
    private int y;
    private int x;

    public Size(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Size ano = (Size) obj;
        return ano.getX() == getX() && ano.getY() == getY();
    }

    public int getY() {
        return y;
    }


    public int getX() {
        return x;
    }

}
