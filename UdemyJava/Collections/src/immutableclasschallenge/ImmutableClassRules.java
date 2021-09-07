package immutableclasschallenge;

public class ImmutableClassRules {

    // The strategy for creating an immutable class is:
    // 1. Don't provide setters
    // 2. Make all fields final and private
    // 3. Don't allow the class to be subclassed
    // 4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
        // - Don't provide methods that modify the mutable objects
        // - Don't share references to the mutable objects

}
