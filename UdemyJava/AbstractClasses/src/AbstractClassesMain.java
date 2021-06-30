public class AbstractClassesMain {
    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Australing ringneck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();

        // how to decide between using abstract class or interface?
        // class -> IS
        // interface -> CAN

        // e.g. a Bird is an Animal, so it makes sense to make an Animal abstract class and inherit
        // but a Bird can fly, so it makes sense to have a Flyable/canFly interface for example implemented in the Bird, but not in the Animal
    }
}
