package challenge6to7;

import java.util.function.Supplier;

public class Challenge6to7 {
    public static void main(String[] args) {
        // challenge 6 and 7
        Supplier<String> iLoveJava = () -> "I love java!";
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }
}
