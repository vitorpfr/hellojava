package lessons;

public class Main {
    public static void main(String[] args) {
        var animal = new Animal("Animal", 1, 1, 5, 5);

        var dog = new Dog("Yorkie", 8, 12, 2, 4, 1, 20, "long silky");

        // eat and move methods are inherited from the Animal class
        dog.eat();

        System.out.println("testing move");
        dog.walk();
        dog.run();
    }
}
