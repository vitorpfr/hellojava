public class ScopeCheck {
    // values inside the class can be accessed:
        // by everyone if public
        // only by this class (or a contained/outer/inner class) if private
        // only by classes in the same package if protected
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck() {
        System.out.println("Scopecheck created, publicVar=" + publicVar + ", privateVar=" + privateVar);
    }

    public int getPrivateVar() {
        return privateVar;
    }

    public void timesTwo() {
        // values inside a method are local
        // symbol with narrower scope is used
        int privateVar = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + (i * privateVar)); // this privateVar has local scope - it is not the class field!

            // logic to find privateVar's value:
            // first it looks in the current enclosing block (for loop). since it doesn't have, it moves to the next one
            // looks at the next enclosing block (method declaration) and finds it!
            // if not found in the method declaration, it would use the class field

            // 'i' is an example of variable with scope local to the for loop's block

            // if we want to specifically use the field, we can fully qualify it using this
            System.out.println(this.privateVar);
        }
    }

    public class InnerClass {
        public int privateVar = 3;

        // this is just a demonstration! not a good practice to use the same name for multiple "nested" variables...
        public InnerClass() {
            int privateVar = 5;
            System.out.println("InnerClass created, local private var is " + privateVar); // local method variable
            System.out.println("InnerClass private var is " + this.privateVar); // InnerClass field/member variable
            System.out.println("ScopeCheck outer class private var is " + ScopeCheck.this.privateVar); // ScopeCheck field/member variable

        }
    }
}
