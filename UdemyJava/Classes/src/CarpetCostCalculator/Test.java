package CarpetCostCalculator;

public class Test {
    public static void main(String[] args) {
        var carpet = new Carpet(3.5);
        var floor = new Floor(2.75, 4.0);
        var calculator = new Calculator(floor, carpet);

        System.out.println("total=" + calculator.getTotalCost());

        var carpet2 = new Carpet(1.5);
        var floor2 = new Floor(5.4, 4.5);
        var calculator2 = new Calculator(floor2, carpet2);

        System.out.println("total=" + calculator2.getTotalCost());


    }
}
