package lessons;

public class CompositionTest {
    public static void main(String[] args) {
        var dimensions = new Dimensions(20, 20, 5);
        var myCase = new Case("220B", "Dell", "240", dimensions);
        var myMonitor = new Monitor("27inch", "Acer", 27, new Resolution(2540, 1440));
        var myMotherboard = new Motherboard("BJ-200", "Asus", 4, 6,"v2.44");

        // now I can create my PC!
        var myPC = new Computer(myCase, myMonitor, myMotherboard);

        // accessing method from inner objects
        // this works, but it is not ideal
//        myPC.getMonitor().drawPixelAt(1500, 1200, "red");
//        myPC.getMotherboard().loadProgram("Windows 1.0");
//        myPC.getTheCase().pressPowerButton();

        // best way is to implement the methods in the PC itself, where they are the ones calling inner methods
        myPC.powerUp();
    }
}
