// abstract class is similar to an interface: you specify the fields and methods, but without implementing them
// it's up to the class inheriting this one to implement them (and it is mandatory for them)

// key difference: interface have only abstract methods, but abstract class can mix up abstract methods, real methods and fields

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();

    public abstract void breathe();

    public String getName() {
        return name;
    }
}
