public class Dog {
    private static String name;

    public Dog(String name) {
        // we're changing the field from the class here - this modifies the name in all objects!
        Dog.name = name;
    }

    public void printName() {
        System.out.println("name=" + name);
    }

    public static void main(String[] args) {
        Dog rex = new Dog("rex");
        Dog fluffy = new Dog("fluffy");

        rex.printName(); // prints fluffy
        fluffy.printName(); // prints fluffy

        // this happens because the fluffy object creation changes the class static variable to "fluffy", which is applied to all instances
    }
}
