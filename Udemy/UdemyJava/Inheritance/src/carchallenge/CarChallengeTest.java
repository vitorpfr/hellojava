package carchallenge;

public class CarChallengeTest {
    public static void main(String[] args) {

        System.out.println("Testing Vehicle class");
        Vehicle vehicle = new Vehicle("Volkswagen", "Fusca", "white");
        vehicle.describe();
        vehicle.move(5);

        System.out.println("-------------------------------------------------");

        System.out.println("Testing Car class");
        Car car = new Car("Volkswagen", "Fusca", "white");
        car.describe();
        car.move(5);
        car.steerLeft();
        car.gearUp();
        car.describe();

        System.out.println("-------------------------------------------------");

        System.out.println("Testing Fusca class");
        Fusca fusca = new Fusca("black");
        fusca.describe();
        fusca.move(5);
        fusca.steerLeft();
        fusca.gearUp();
        fusca.gearUp();
        fusca.gearDown();
        fusca.describe();
        fusca.describe();
        fusca.spitFire();
    }
}
