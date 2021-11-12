public class KeywordsAndExpressions {
    public static void main(String[] args) {
        // keywords: words reserved by java (int, false, else, break, continue, etc)

//        int int = 5; // trying to use a reserved keyword

        int int2 = 5; // but you can use part of a reserved keyword


        // expressions
        // in this example: 'kilometers = (100 * 1.609344)' is the expression (everything besides double)
        // expression: composed of variables, values and operators
        // data type + expression: a valid Java statement
        double kilometers = (100 * 1.609344);

        // in this case, the expression is 'highScore = 50'
        int highScore = 50;

        // in a control flow statement, the component in brackets is an expression 'highScore == 50'
        // and the string inside the println method is also an expression
        if (highScore == 50) {
            System.out.println("This is an expression");
        }

    }
}
