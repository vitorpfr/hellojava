package carchallenge;

public class Car extends Vehicle {
    private int steeringDirection;
    private int currentGear;

    public Car(String manufacturer, String name, String color) {
        super(manufacturer, name, color);
        this.steeringDirection = 0;
        this.currentGear = 0;
    }

    public int getSteeringDirection() {
        return steeringDirection;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void steerLeft() {
        this.steeringDirection = -1;
    }

    public void steerRight() {
        this.steeringDirection = 1;
    }

    public void steerCenter() {
        this.steeringDirection = 0;
    }

    public boolean gearUp() {
        if (currentGear < 5) {
            this.currentGear++;
            return true;
        } else {
            return false;
        }
    }

    public boolean gearDown() {
        if (currentGear > 0) {
            this.currentGear--;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void describe() {
        super.describe();
        String direction;
        switch(steeringDirection) {
            case -1:
                direction = "left";
                break;
            case 0:
                direction = "center";
                break;
            case 1:
                direction = "right";
                break;
            default:
                direction = "center";
                break;
        }
        System.out.println("It is a car at current gear " + currentGear + " and towards the " + direction);
    }
}
