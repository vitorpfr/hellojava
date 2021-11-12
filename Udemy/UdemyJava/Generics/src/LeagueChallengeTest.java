public class LeagueChallengeTest {
    public static void main(String[] args) {

        var neymar = new SoccerPlayer("Neymar");
        var psg = new Team<SoccerPlayer>("Paris Saint Germain");
        psg.addPlayer(neymar);

        var messi = new SoccerPlayer("Messi");
        var barcelona = new Team<SoccerPlayer>("Barcelona");
        barcelona.addPlayer(messi);

        var cristianoRonaldo = new SoccerPlayer("Cristiano Ronaldo");
        var juventus = new Team<SoccerPlayer>("Juventus");
        juventus.addPlayer(cristianoRonaldo);

        var soccerLeague = new League<SoccerPlayer, Team<SoccerPlayer>>();

        soccerLeague.addTeam(barcelona);
        soccerLeague.addTeam(juventus);
        soccerLeague.addTeam(psg);

        // gives an error because it is not a soccer team (incompatible team)
//        var otherTypeOfTeam = new Team<BaseballPlayer>("myTestTeam");
//        soccerLeague.addTeam(otherTypeOfTeam);

        // register matches
        barcelona.matchResult(juventus, 5, 0);
        barcelona.matchResult(psg, 3, 0);
        juventus.matchResult(psg, 2, 1);

        // check rankings
        System.out.println(barcelona.ranking());
        System.out.println(juventus.ranking());
        System.out.println(psg.ranking());

        // print overall rankings
        soccerLeague.printRankings();
    }
}
