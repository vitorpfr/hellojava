package carchallenge;

public class Vehicle {
    private final String manufacturer;
    private final String name;
    private final String color;
    private int currentSpeed;

    public Vehicle(String manufacturer, String name, String color) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.color = color;
        this.currentSpeed = 0;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void move(int speed) {
        this.currentSpeed = speed;
        if (speed == 0) {
            System.out.println("Speed change: Vehicle " + manufacturer + " " + name + " stopped.");
        } else {
            System.out.println("Speed change: Vehicle " + manufacturer + " " + name + " is now moving at speed " + currentSpeed + ".");
        }
    }

    public void describe() {
        System.out.println("This is a " + color + " " + manufacturer + " " + name + ", currently at speed " + currentSpeed);
    }
}
