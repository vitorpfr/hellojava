package lessons;

public class Reference {

    public static void main(String[] args) {
        // This line creates a Dog object in the memory
        // 'dog' makes a reference to this object
        Dog dog = new Dog("aaa", 1,1,1,1,1,1, "bbbb");

        // We're not duplicating the object here!
        // 'anotherDog' is a reference to the same object as 'dog' points in memory
        Dog anotherDog = dog;

        // summary: only by using 'new' that new objects are instantiated in memory
    }

}
