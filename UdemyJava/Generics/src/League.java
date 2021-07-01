import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Player, U extends Team<T>> {
    private ArrayList<U> teams;

    public League() {
        this.teams = new ArrayList<U>();
    }

    public boolean addTeam(U newTeam) {
        if (teams.contains(newTeam)) {
            System.out.println("Team was already added!");
            return false;
        } else {
            teams.add(newTeam);
            return true;
        }
    }

    public void printRankings() {
        // this function uses the 'compareTo' method overriden in the Team class to sort (which compares the teams ranking)
        Collections.sort(teams);

        System.out.println("Ranking:");
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + teams.get(i).getName() + ", with " + teams.get(i).ranking() + " points");
        }
    }
}
