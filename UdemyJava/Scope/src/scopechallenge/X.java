package scopechallenge;

import java.util.Scanner;

public class X {

//    private static Scanner scanner = new Scanner(System.in);

    private int x;

    public X(Scanner x) {
        System.out.println("Type an int");
        this.x = x.nextInt();
    }

    public void x() {
        for (int x = 1; x <= 12; x++) {
            System.out.println(this.x * x);
        }
    }
}
