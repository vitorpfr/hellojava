import java.util.ArrayList;

// <T> indicates that there's gonna be a type (class) there
// this class can be used throughout the code as the T symbol (T is like a variable for any receivable class
// formally, T is a type paramater of the Team class

// when we instantiate Team<MyClass>, all T occurrences will be replaced by Java for MyClass

// issue: Any T class is accepted!
//public class Team<T> {
// solution to limit what T can be: extend it

// implements comparable; make it possible to compare team points! we use Team<T> to force this instance to be compared with the same Team type (eg.. Team<FootballPlayer>)
public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // needs to cast player to Player class, so it recognizes getName method
    // we need to do this because player could be any class theoretically
    // we can do this here because we intend to use Team only with Player classes
    // this is an ugly solution, but temporary

    // permanent solution: declare that T extends Player in the Team declaration!
    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            won++;
        } else if (ourScore == theirScore) {
            tied++;
        } else {
            lost++;
        }

        played++;

        if (opponent != null) {
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return ((won * 3) + tied);
    }

    @Override
    public int compareTo(Team<T> team) {

        // we return -1 because the higher the score, the better (so it comes first in an order)
        if (this.ranking() > team.ranking()) {
            return -1;
        }

        else if (this.ranking() < team.ranking()) {
            return 1;
        }

        else {
            return 0;
        }
    }
}
