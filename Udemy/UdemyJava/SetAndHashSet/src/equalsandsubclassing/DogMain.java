package equalsandsubclassing;

public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        // initially this returns true and false, which doesn't make sense
        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
        // this violates the equals rule

        // reason is Labrador is instanceOf Dog, but Dog is not instanceOf Labrador
        // solution: do not override equals() in Labrador class, and mark equal() override as final in Dog class
    }
}
