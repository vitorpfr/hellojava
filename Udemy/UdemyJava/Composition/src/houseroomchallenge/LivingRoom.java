package houseroomchallenge;

public class LivingRoom {

    private Rack rack;
    private Sofa sofa;
    private Television television;

    public LivingRoom(Rack rack, Sofa sofa, Television television) {
        this.rack = rack;
        this.sofa = sofa;
        this.television = television;
    }

    // not a good way to do it, just to demonstrate
    public Television getTelevision() {
        return television;
    }

    public void turnOnTV() {
        television.turnOn();
    }

    public void turnOffTV() {
        television.turnOff();
    }
}
