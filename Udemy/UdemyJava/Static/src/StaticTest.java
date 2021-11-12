public class StaticTest {
    private static int numInstances = 0; // this needs to be static so the number is stored in the class, and not in the object
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }

    public static int getNumInstances() {
        return numInstances;
    }

    public String getName() {
        return name;
    }
}
