package banking;

// This package will demonstrate the usage of JUnit library for writing unit tests.
// Unit tests operate on methods individually.
// JUnit is shipped with intellij, but it is not added to a project by default

// How to add JUnit to project:
// - Put the cursor on the class to be tested, option+enter, then "Create test"
// - In the pop-up, add Junit to project and mark methods that will have tests
// - IntelliJ will create the class YourClassTest, with the test methods set-up to be written

// Sometimes intellij will not recognize the Test import because it sets the JUnit library to run only on tests
// To fix it: go to File, Project Structure, Modules, select module, dependencies, change JUnit from "Test" to "Compile"

public class BankingMain {
    public static void main(String[] args) {
        System.out.println("The application is running");
    }
}
