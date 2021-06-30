import java.util.Scanner;

public class InnerClasses {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        // creating object of normal class
//        Gearbox mcLaren = new Gearbox(6);

        // creating object of inner class (uses the object of the outer class to do it)
        // you ALWAYS need to have an instance of the outer class to be able to instantiate an object of the inner class!
//        Gearbox.Gear first = mcLaren.new Gear(1, 12.3); // right
//        Gearbox.Gear second = new Gearbox.Gear(2, 15.4);  // wrong way
//        Gearbox.Gear third = new mcLaren.Gear(1, 2) // wrong way

        // disclaimer: this is just an example below of using public inner classes, which is highly discouraged;
        // in the real world the inner class probably would be private and we'd just interact with the Gearbox object directly
        // now changing Gear to private


        // testing Gearbox with inner class Gear
        // setup
        Gearbox mcLaren = new Gearbox(6);

        // operating
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));

        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));

        // notice that we didn't need to deal with the Gear (inner) class, but Gear objects are being used inside mcLaren!


        // Local class: a class only used here (inside the main method)

        // overall idea:
        // btnPrint is a Button object.
        // The button has a title (what's written on it) and a onClickListener object, which has the method onClick (executed when the button is clicked)
        // the class of the onClickListener inside the button is defined as a local class here (ClickListener)
        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I've been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        }

        // here the onClickListener object is created with the class above
        btnPrint.setOnClickListener(new ClickListener());
//        listen();

        // Anonymous class: a local class with no name
        // it is useful when multiple classes are needed in the same code (ex: defining listeners for each button in a screen;
        // each button needs to do something, so each one needs its own class)

        // here the class is defined and instantiated inside the ()s
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
    }

    private static void listen() {
        boolean quit = false;

        while (!quit) {
            // this is simulating a button click from a UI framework
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;

                // if the button is clicked (mock: user typed 1), onClick method is executed
                case 1:
                    btnPrint.onClick();
            }
        }
    }


}
