package scopechallenge;

import java.util.Scanner;

// disclaimer: this challenge is not a good programming practice! it is just an exercise to understand scope
public class ScopeChallengeMain {


    public static void main(String[] args) {
        X x = new X(new Scanner(System.in));
        x.x();
    }
}
