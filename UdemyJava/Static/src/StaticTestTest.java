public class StaticTestTest {

    public static int multiplier = 7;

    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("1st");

        StaticTest secondInstance = new StaticTest("2nd");

        System.out.println(StaticTest.getNumInstances());

        System.out.println(multiply(5));

    }

    public static int multiply(int n) {
        return n * multiplier;
    }
}
