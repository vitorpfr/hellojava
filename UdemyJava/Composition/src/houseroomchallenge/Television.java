package houseroomchallenge;

public class Television {
    private final int inches;
    private final String manufacturer;
    private final boolean isFullHD;
    private boolean isOn;

    public Television(int inches, String manufacturer, boolean isFullHD) {
        this.inches = inches;
        this.manufacturer = manufacturer;
        this.isFullHD = isFullHD;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("TV was turned on");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("TV was turned off");
    }

    public boolean isOn() {
        return isOn;
    }
}
