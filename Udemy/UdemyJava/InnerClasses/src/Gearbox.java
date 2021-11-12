import java.util.ArrayList;

// summary: a Gearbox is composed of gears (represented in an ArrayList)
// therefore, the Gear only makes sense inside a Gearbox, so it is created as an inner class
public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        for (int i = 0; i < maxGears; i++) {
            addGear(i, i * 5.3);
        }
    }

    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    public void addGear(int number, double ratio) {
        if ((number > 0) && (number <= maxGears)) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear) {
        if((newGear >= 0) && (newGear < gears.size()) && clutchIsIn) {
            currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        } else {
            System.out.println("Grind!");
            currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if (clutchIsIn) {
            System.out.println("Scream!!!");return 0.0;

        }


        return (revs * gears.get(currentGear).getRatio());
    }



    // creating Gear as an inner class of Gearbox
    // reason: a gear isn't something useful on its own, it only makes sense inside a gearbox
    // instances of the inner class have access to all methods of outer class (even privates)
    private class Gear {
        int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber; // this fields shouldn't have the same name as the fields of the outer class (avoid shadowing)
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs) {
            return revs * ratio;
        }
    }
}
