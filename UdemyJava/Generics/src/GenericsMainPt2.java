public class GenericsMainPt2 {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

//        Team adelaideCrows = new Team("Adelaide Crows");
//        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);
//
//        System.out.println(adelaideCrows.numPlayers());

        // issue: Team class accepts players of any type (so we can have teams with players of different sports, which is non-intended

        // solutions:
        // 1: create multiple Team classes (FootballTeam, SoccerTeam)
            // issue: the code will almost be identical, so duplicating code

        // 2: define Team class as abstract with common functionality (addPlayer, etc), and have other Team classes extending this one
            // this is better, but Java generics is an ever better solution here

        // 3: Modify team to be a generic class
            // best option!

        // applying 3:
        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat); // doesn't work anymore because it is not a FootballPlayer
//        adelaideCrows.addPlayer(beckham); // doesn't work anymore because it is not a FootballPlayer
        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> chicagoCubs = new Team<>("Chicago Cubs");
        chicagoCubs.addPlayer(pat);

        // there are still issues: we can use any type!
        // this compiles, but breaks because String cannot be cast to Player
//        Team<String> brokenTeam = new Team<>("this won't work");
//        brokenTeam.addPlayer("no-one");

        Team<SoccerPlayer> aa = new Team<>("soccer");
        aa.addPlayer(beckham);

        // testing match result
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");
        adelaideCrows.matchResult(fremantle, 2, 1); // 2 points
        adelaideCrows.matchResult(fremantle, 1, 1); // 1 point
        adelaideCrows.matchResult(fremantle, 1, 4);
        adelaideCrows.matchResult(fremantle, 1, 5);
//        adelaideCrows.matchResult(chicagoCubs, 2, 1); // this doesn't work because matchResult arg needs to be a Team<FootballPlayer>, and chicagoCubs is a Team<BaseballPlayer>

        System.out.println(adelaideCrows.ranking());
        System.out.println(fremantle.ranking());
        System.out.println(adelaideCrows.compareTo(fremantle));

        // why do we implement Comparable in the Team class?
        // so we can use the Collections.sort(teams) function (it uses the compareTo method that was overridden)


    }
}
