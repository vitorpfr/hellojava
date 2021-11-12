import org.w3c.dom.Node;

public class PackagesMain {

    public static void main(String[] args) {

        // can't import two classes with the same name
        // if not imported, need to use fully qualified name (with package)
        java.lang.reflect.Type type = null;
        com.sun.jdi.Type anotherType = null;

        // if imported, I can use only the class name
        Node node = null;

        // java.lang and java.util are examples of packages
        // you don't need to import java.lang because it is automatically imported on every class
        java.lang.Integer myInt = 5;
        Integer myOthetInt = 6;
    }
}
