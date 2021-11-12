public class Wall {
    private double width;
    private double height;

    public Wall() {

    }

    public Wall(double width, double height) {
        this.width = (width < 0) ? 0 : width;
        this.height = (height < 0) ? 0 : height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = (width < 0) ? 0 : width;
    }

    public void setHeight(double height) {
        this.height = (height < 0) ? 0 : height;
    }

    public double getArea() {
        return (width * height);
    }

    public static void main(String[] args) {
        var w1 = new Wall(5, 4);
        System.out.println(w1.getArea());
        w1.setHeight(-1.5);
        System.out.println(w1.getWidth());
        System.out.println(w1.getHeight());
        System.out.println(w1.getArea());
    }
}
