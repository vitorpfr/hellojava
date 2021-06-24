public class EncapsulationTest {
    public static void main(String[] args) {

        var player = new Player();
        player.name = "Tim";
        player.health = 20;
        player.weapon = "Sword";

        player.loseHealth(10);
        System.out.println("Remaining health = " + player.healthRemaining());

        player.health = 200; // a user of the Player class should not have permission to do this!
        player.loseHealth(11);
        System.out.println("Remaining health = " + player.healthRemaining());

        // big issue here: since the Player fields are public, anyone can change health directly instead of using
        // the proper loseHealth method, which performs some validations (there's no isolation!)

        // another issue: if 'name' field changes to fullName, I need to fix it here
        // so I need to end up understanding how the class is implemented (and this should be completely isolated from me via a getter method)

        // now doing properly, using encapsulation
        var myPlayer = new EnhancedPlayer("Vitor", 50, "sword");
        System.out.println(myPlayer.toString());

    }
}
