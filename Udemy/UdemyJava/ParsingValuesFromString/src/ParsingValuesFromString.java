public class ParsingValuesFromString {
    public static void main(String[] args) {
        String numberAsString = "2018";
        System.out.println(numberAsString);

        // after converting to int, I can make operations
        int number = Integer.parseInt(numberAsString);
        System.out.println(number + 1);

        // parsing non-numeric strings throws exception
//        Integer.parseInt("2018a");

        // Double class also has parse method
        double anotherNumber = Double.parseDouble("2018.125");
        System.out.println(anotherNumber + 1);
    }
}
