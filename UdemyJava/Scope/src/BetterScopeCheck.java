public class BetterScopeCheck {
    public int publicVar = 0;
    private int varOne = 1;

    public BetterScopeCheck() {
        System.out.println("Created");
    }

    public void timesTwo() {
        int varTwo = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + i * varTwo);
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree is " + innerClass.varThree);
    }

    public class InnerClass {
        private int varThree = 3;

        public InnerClass() {
            System.out.println(varOne + " and " + varThree); // varTwo is out of scope here
        }
    }
}
