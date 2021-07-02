// we're using here the classes from the Packages.jar file that we generated!
import com.example.game.ISaveable;
import com.example.game.Monster;
import com.example.game.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportPackageTest {
    // Packages module was built as an artifact (JAR)
    // here we're going to import use and use its com.example.game package

    // File > Project structure > Libraries > Add > Java > select .jar file > Select modules to add


    public static void main(String[] args) {
        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);                // .toString is not necessary, since println already casts data to string!
        tim.setWeapon("Stormbringer");
        saveObject(tim);

//        loadObject(tim);
        // loadObject changed all 'tim' attributes, so this will be different!
//        System.out.println(tim);


        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf);
        System.out.println("Strength: " + ((Monster) werewolf).getHitPoints()); // casting werewolf to Monster, so it can access its methods
        saveObject(werewolf);


    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    // since tihs method receives an ISaveable object, it can be used to save data of any type of class that uses this interface!
    public static void saveObject(ISaveable objectToSave) {

        List<String> objectData = objectToSave.write();
        for (int i = 0; i < objectData.size(); i++) {
            System.out.println("Saving " + objectData.get(i) + " to storage device");
            // this is the line that would be saving this data into a file, for example
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        // readValues() simulates getting data from a file, for example, and adding to a List
        List<String> values = readValues();

        // given the data is in the list, we just need to call .read in the object and pass the List with the data
        objectToLoad.read(values);
    }

}
