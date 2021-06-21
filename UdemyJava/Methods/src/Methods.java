public class Methods {

    // challenge 1
    public static void displayHighScorePosition(String playerName, int playerPosition) {
        System.out.println(playerName + " managed to get into position " + playerPosition + " on the high score table");
    }

    public static int calculateHighScorePosition(int playerScore) {
        if (playerScore >= 1000) {
            return 1;
        } else if (playerScore >= 500) {
            return 2;
        } else if (playerScore >= 100) {
            return 3;
        }
        return 4;
    }

    public static void main(String[] args) {
        displayHighScorePosition("John", calculateHighScorePosition(1500));
        displayHighScorePosition("Mike", calculateHighScorePosition(1000));
        displayHighScorePosition("Mary", calculateHighScorePosition(900));
        displayHighScorePosition("Paul", calculateHighScorePosition(400));
        displayHighScorePosition("Tom", calculateHighScorePosition(50));

        int newScore = calculateScore("tim", 500);
        System.out.println("New score is " + newScore);
        calculateScore(75);
        calculateScore();
    }

    // coding exercises done on each class file

    // method overloading
    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    // same name as method above, but with different args
    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return 0;
    }
}
