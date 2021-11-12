public class StatementsWhitespaceAndIndentation {
    public static void main(String[] args) {
        // 'myVariable = 50' is an expression
        // the whole line is an statement (data type + expression + ';')
        int myVariable = 50;

        // another possible statement
        myVariable++;

        // another statement ('oi' is an expression)
        System.out.println("oi");

        // statements don't have to be one-liner, it looks for the ; to understand where it ends!
        System.out.println("this is a statement " +
                "with more than one " +
                "line!");

        // you can also have multiple statements in one line
        // but it is not recommended for readability!
        int anotherVariable = 50; anotherVariable--; System.out.println(anotherVariable);

        // good practice: have 1 space between assignment operators
        int myVariable2 = 50;
        // is better than
        int myVariable3=50;

        // identation also helps to read stuff, not mandatory but highly recommended
    }
}
