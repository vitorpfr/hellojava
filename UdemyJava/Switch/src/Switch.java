public class Switch {
    public static void main(String[] args) {
        int value = 3;

        // with if
//        if (value == 1) {
//            System.out.println("Value was 1");
//        } else if (value == 2) {
//            System.out.println("Value was 2");
//        } else {
//            System.out.println("Was not 1 or 2");
//        }

        // better solution: use switch statement
        // breaks are necessary to avoid testing the next cases
        int switchValue = 4;
        switch(switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;

            case 2:
                System.out.println("Value was 2");
                break;

            case 3: case 4: case 5:
                System.out.println("Value was 3, 4 or 5");
                System.out.println("Actually, it was a " + switchValue);
                break;

            default:
                System.out.println("Was not the numbers above");
                break;
        }

        // switch statement with char
        char charValue = 'D';
        switch(charValue) {
            case 'A': case 'B': case 'C': case 'D': case 'E':
                System.out.println("Value is " + charValue);
                break;

            default:
                System.out.println("Value is none of the above");
                break;
        }

        // how to deal with lower case as well?
        // use string class method toLowerCase, so it tests with lower case always
        String month = "JANUARY";
        switch(month.toLowerCase()) {
            case "january":
                System.out.println("Jan");
                break;

            case "june":
                System.out.println("Jun");
                break;

            default:
                System.out.println("Not sure");
                break;
        }
    }
}
