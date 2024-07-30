public class Index2D implements Pixel2D {
    private int _x, _y;

    public Index2D() {
        this(0, 0);
    }

    public Index2D(int x, int y) {
        _x = x;
        _y = y;
    }

    public Index2D(Pixel2D t) {
        this(t.getX(), t.getY());
    }

    @Override
    public int getX() {
        return _x;
    }

    @Override
    public int getY() {
        return _y;
    }

    @Override
    public double distance2D(Pixel2D t) throws RuntimeException {
        double ans = 0;
        if (t == null) {
            throw new RuntimeException("RuntimeException");
        }
        double dx = this._x - t.getX();
        double dy = this._y - t.getY();
        ans = Math.sqrt(dx * dx + dy * dy);
        return ans;
    }

    @Override
    public String toString() {
        return getX() + "," + getY();
    }

    @Override
    public boolean equals(Object t) {
        boolean ans = false;
        if (t != null && t instanceof Pixel2D) {
            Pixel2D p3 = new Index2D(3, 2);
            Pixel2D p = (Pixel2D) t;
            ans = this.distance2D(p) == 0;

        }
        return ans;
    }


}