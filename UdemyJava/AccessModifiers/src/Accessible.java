// What is the visibility of each element above?
// interface Accessible is package-private (accessible by all classes within the same package), because it lacks access modifier
// all of the rest are public, because interfaces can only have 'public static final' elements

// since the interface itself is package-private, the methods will naturally only be accessed in the package


interface Accessible {
    int SOME_CONSTANT = 100;
    public void methodA();
    void methodB();
    boolean methodC();
}
