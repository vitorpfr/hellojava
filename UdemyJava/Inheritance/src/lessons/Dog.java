package lessons;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        // super calls the constructor from the class that this one is inheriting from
        // first initializing the parameters from the Animal class using the constructor
        super(name, 1, 1, size, weight);

        // then, initializing the Dog specific parameters
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog.chew() called");
    }

    // overriding an Animal method
    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();

        // calls the eat method from the Animal class (even if there's an eat method being overridden here)
        super.eat();
    }

    public void walk() {
        System.out.println("Dog.walk() called");
        // calls the move method (first look for one here, if not found, uses the method from the parent class)
        move(5);

        // here I could use super.move(5) instead of move(5), because the move method is in the Animal class
        // the reason that I'm using move() is that, if the move method is overridden, this method will start to use the new method automatically
    }

    public void run() {
        System.out.println("Dog.run() called");
        move(10);
    }
}
