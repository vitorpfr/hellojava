public class Point {
    private int x;
    private int y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }

    public double distance(Point p) {
        return this.distance(p.getX(), p.getY());
    }

    public double distance() {
        return this.distance(0,0);
    }

    public static void main(String[] args) {
        Point first = new Point(6, 5);
        Point second = new Point(3, 1);
        System.out.println("distance(0,0)=" + first.distance());
        System.out.println("distance(second)=" + first.distance(second));
        System.out.println("distance(2,2)=" + first.distance(2,2));

        Point point = new Point();
        System.out.println(point.distance());
    }
}
