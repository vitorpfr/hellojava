package printerchallenge;

public class PrinterChallengeTest {
    public static void main(String[] args) {
        var myPrinter = new Printer(true);

        System.out.println(myPrinter.toString());
        myPrinter.printPage(1);
        System.out.println(myPrinter.toString());
        myPrinter.printPage(40);
        System.out.println(myPrinter.toString());
        myPrinter.fillToner(100);
        System.out.println(myPrinter.toString());

        System.out.println("-----------------------------");
        System.out.println("starting other printer");
        var myOtherPrinter = new Printer(false);
        System.out.println(myOtherPrinter.toString());
        myOtherPrinter.printPage(60);
        System.out.println(myOtherPrinter.toString());
        myOtherPrinter.fillToner(30);
        System.out.println(myOtherPrinter.toString());

    }
}
