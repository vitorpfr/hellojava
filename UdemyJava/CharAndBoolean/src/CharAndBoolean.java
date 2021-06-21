public class CharAndBoolean {

    public static void main(String[] args) {

        // char: used to store characters
        // you can store a single character per char
//        char myChar = 'DD'; // won't work

        char myChar = 'D'; // works

        // a char occupies two bytes in memory (16 bits) and therefore has a width of 16
        // it does so because it allows you to store Unicode characters
        // so, using 16 bits, 65535 (2^16 - 1) characters can be represented

        // reference of unicode translation: https://unicode-table.com/
        // for example, the letter D is 0044 in hex
        char myUnicode = '\u0044';
        System.out.println(myChar);
        System.out.println(myUnicode);                          // this prints the D!


        // doing the same thing for the copyright symbol, which is 00A9
        char myCopyrightChar = '\u00A9';
        System.out.println(myCopyrightChar);


        // boolean: can only be set to true or false
        boolean myTrueBoolean = true;
        boolean myFalseBoolean = false;

        boolean isCustomerOver21 = true;
    }
}
