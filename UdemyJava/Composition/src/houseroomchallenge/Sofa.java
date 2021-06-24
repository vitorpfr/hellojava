package houseroomchallenge;

public class Sofa {
    private String color;
    private double width;
    private double height;
    private double length;
    private int seats;
    private boolean extensibleToBed;

    public Sofa(String color, double width, double height, double length, int seats, boolean extensibleToBed) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.length = length;
        this.seats = seats;
        this.extensibleToBed = extensibleToBed;
    }
}
