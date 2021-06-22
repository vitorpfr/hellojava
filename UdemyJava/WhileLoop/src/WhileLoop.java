public class WhileLoop {

    public static boolean isEvenNumber(int n) {
        return (n % 2 == 0);
    }

    public static void main(String[] args) {
        int count = 0;
        while (count != 5) {
            System.out.println("Count value is " + count);
            count++;
        }

        int number = 4;
        int finishNumber = 20;
        int evenCounter = 0;

        while (number <= finishNumber) {
            number++;
            if (!isEvenNumber(number)) {
                continue;
            }

            evenCounter++;
            System.out.println("Even number: " + number);

            if (evenCounter == 5) {
                System.out.println("Found 5 even numbers, finishing while loop");
                break;
            }
        }

        System.out.println("now showing do while");

        int myCounter = 0;

        do {
            System.out.println("counter is in " + myCounter);
            myCounter++;
        } while (myCounter < 20);


        // main difference:
        // while loop check the condition before executing the code block
        // do-while always execute the block before checking the condition
    }
}
