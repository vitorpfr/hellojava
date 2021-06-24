package carchallenge;

public class Fusca extends Car {
    public Fusca(String color) {
        super("Volkswagen", "Fusca", color);
    }

    public void spitFire() {
        System.out.println(this.getManufacturer() + " " + this.getName() + " is spitting fire! That's so cool!");
    }
}
