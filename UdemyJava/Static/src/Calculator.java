public class Calculator {

    private int a;
    private int b;

    private static double PI = 3.1415;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum2() {
        return a + b;
    }

    public static int sum(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        // STATIC VS INSTANCE METHODS

        // since 'sum' is a static method, it can be called without instantiating a new object
        System.out.println(Calculator.sum(3, 5)); // returns 8

        // the other 'sum', however, is a instance method - we can only call it after creating a Calculator object
        Calculator myCalc = new Calculator(10, 15);
        System.out.println(myCalc.sum2()); // returns 25


        // STATIC VS INSTANCE VARIABLES
        System.out.println(Calculator.PI); // static variables are accessed in the class level
        System.out.println(myCalc.a); // instance variables are accessed in the instance (object) level


    }
}
