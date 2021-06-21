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

        // if-then: basic control flow statement
        // here we use the == operator, which checks for equality of operands
        boolean isAlien = false;
        if (isAlien == false)
            System.out.println("It is not an alien!");

        if (isAlien == true)
            System.out.println("This is not printed");

        // this could be simplified to:
        if (!isAlien)
            System.out.println("It is not an alien! v2");

        boolean alienStatement = !isAlien;
        if (alienStatement)
            System.out.println("oi");

        // issue of not using code blocks ({}): it only evaluates one line of code, which is bad!
        // so, always use a code block!
        if (!isAlien) {
            System.out.println("aaa");
            System.out.println("bbb");
        }

        int topScore = 90;
        if (topScore >= 100) {
            System.out.println("High score!");
        }

        // logical AND operator (&&)
        int secondTopScore = 60;
        if ((topScore > secondTopScore) && (topScore < 100)) {
            System.out.println("success!");
        }

        // logical OR operator (||)
        int thirdTopScore = 40;
        if ((topScore > 90) || (topScore < 110)) {
            System.out.println("success!");
        }

        // warning: & and | are bitwise and/or, we want here the logical and/or! (&& and ||)
        // bitwise operator works with bit operands (bit1 or bit2)
        // logical operator works with boolean opearnds (boolean1 or boolean2)

        int newValue = 50;
        // correct is newValue == 50
        // if you try to use assignment operator (=), it will return the newly assigned value instead of the boolean evaluation
//        if (newValue = 50) {
//            System.out.println("This is an error!");
//        }

        // this is dangerous: the if statement is re-assigning true to isCar1 and returning it, so the if check passes
        boolean isCar1 = false;
        if (isCar1 = true) {
            System.out.println("this should not be printed, but it is");
        }

        // correct: use == operator
        boolean isCar2 = false;
        if (isCar2 == true) {
            System.out.println("this should not be printed, and it is not");
        }

        // simplifying
        if (isCar2) {
            System.out.println("this should not be printed, and it is not");
        }

        System.out.println("! prints the opposite: " +  !isCar2);

        // ternary operator
        // it is a shortcut of if/then/else to assign a value to a variable
        // format: logicalExpression ? valueIfTrue : valueIfFalse
        boolean isCar = true;
        int myNumber = isCar ? 5 : 0;
        System.out.println(myNumber); // prints 5, because isCar is true


        boolean isBus = false;
        int myOtherNumber = isBus ? 5 : 0;
        System.out.println(myOtherNumber); // prints 0, because isBus is false

        // another example
        int ageOfClient = 20;
        boolean isEighteenOrOver = (ageOfClient >= 18) ? true : false;
        System.out.println(isEighteenOrOver);

        // this case wouldn't need to be a ternary operator
        boolean isTwentyOrOver = (ageOfClient >= 20);
        System.out.println(isTwentyOrOver);

        // operators challenge
        double myDouble1 = 20.00;
        double myDouble2 = 80.00;
        double opResult = (myDouble1 + myDouble2) * 100.00;
        System.out.println(opResult); // 10000.0

        double remainder = opResult % 40.00;
        System.out.println(remainder); // 0.0

        boolean isRemainderZero = (remainder == 0);
        System.out.println(isRemainderZero);

        if (!isRemainderZero) {
            System.out.println("Got some remainder! (this should not be printed)");
        }

        // if with else:
        if (1 == 2 ) {
            System.out.println("this is impossible, not printed");
        } else if (1 == 3) {
            System.out.println("This si also impossible, also not printed");
        } else {
            System.out.println("this will be printed!");
        }

    }
}
