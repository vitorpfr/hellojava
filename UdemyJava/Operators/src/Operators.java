public class Operators {
    public static void main(String[] args) {

        // summary of operators: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html

        // = and + are operators:
        // = is an assignment operator - assigns a value
        // + is an addition operator

        // 1 and 2 are operands - they are the arguments of the operator
        int result = 1 + 2;

        System.out.println("result is " + result); // result is 3

        int previousResult = result;

        System.out.println("previous result is " + previousResult); // previousResult is also 3

        result = result - 1;
        System.out.println("result is " + result); // result is now 2
        System.out.println("previous result is " + previousResult); // but previousResult is still 3

        // this happens because assignment of previousResult creates a copy of the data in memory (it doesn't reference the same address)

        result = result * 10;
        System.out.println(result); // 20

        result = result / 5;
        System.out.println(result); // 4

        result = result % 3;
        System.out.println(result); // 1 (remainder of 4 / 3)

        // abbreviation of 'result = result + 1'
        result++;
        System.out.println(result); // now 2 (1 + 1)

        result--;
        System.out.println(result); // now 1 (2 - 1)

        // abbreviation of 'result = result + 2'
        result += 2;
        System.out.println(result); // now 3 (1 + 2)

        result *= 10;
        System.out.println(result); // now 30

        result /= 3;
        System.out.println(result); // now 10

        result -= 2;
        System.out.println(result); // now 8

    }
}
