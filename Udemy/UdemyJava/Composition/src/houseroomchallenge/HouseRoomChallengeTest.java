package houseroomchallenge;

public class HouseRoomChallengeTest {
    public static void main(String[] args) {
        LivingRoom myRoom = new LivingRoom(
                new Rack("wood", 3.0, 5.0, 7.0),
                new Sofa("blue", 10, 3, 5, 2, true),
                new Television(55, "Samsung", true));

        myRoom.turnOnTV();
        System.out.println(myRoom.getTelevision().isOn());
        myRoom.turnOffTV();
        System.out.println(myRoom.getTelevision().isOn());
    }
}
