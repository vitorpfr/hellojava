import java.util.HashSet;
import java.util.Set;

// If the class/object is going to be used in a set or map (key), it needs to override equals() and hashCode()
// so it can recognize that Pluto, 248 is equal to Pluto, 842 (they are different objects, but same name)
public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    // if this returns satellites directly, we allow the user to change it! this is really bad
    // returning a new set with the elements protects our data
    public Set<HeavenlyBody> getSatellites() {
//        return satellites;
        return new HashSet<>(satellites);
    }

    // if I defined the arg as HeavenlyBody, I would be overloading the method
    // here I want to override it
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        // here we don't use instanceOf, to make sure sub-classes are not considered equal!
        // checking for null is required to call .getClass()
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    // how hashed collections work: each entry is assigned to a bucket via hashcode
    // every object in the same bucket has the same hashcode
    // e.g. if my hashCode function returns always 0, all objects will be in the same bucket (which is not good)

    // the issue of returning the hashCode of the planet name is that mars Object would have same hashcode as "Mars" string
    // solution: add a number to the planet name's hashcode, so two "Mars" objects have the same hashcode, which is different from "Mars" string
    @Override
    public int hashCode() {
        System.out.println("Hashcode called");
        return this.name.hashCode() + 57;
    }
}
