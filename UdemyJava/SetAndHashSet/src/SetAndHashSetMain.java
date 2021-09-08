import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetAndHashSetMain {
    // set doesn't have duplicates
    // Set: interface that define the basic methods (add, remove, clear, size, isEmpty, contains)
    // HashSet: class

    // now modeling the solar system
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        var earth = new HeavenlyBody("Earth", 1.0);
        var earthsMoon = new HeavenlyBody("Moon", 0.5);

        System.out.println(earth.getSatellites()); // no satellites yet
        earth.addMoon(earthsMoon);
        System.out.println(earth.getSatellites()); // now it has one - the moon

        // let's try to clear the satellites list
        earth.getSatellites().clear();

        // now let's see how many satellites are there
        System.out.println(earth.getSatellites()); // it still has one! because getSatellites returns a new list on each call


        //// now using the solar system objects
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        // print planets
        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        var body = solarSystem.get("Mars");
        System.out.println("Moons of " + body.getName());
        for (HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }

        // generate a set of all the moons in the solar system using addAll method
        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }
        System.out.println("All Moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        // trying to adding a duplicated mars
        var newMars = new HeavenlyBody("Mars", 45);
        solarSystem.put(newMars.getName(), newMars);
        planets.add(newMars);

        // print planets - shows mars is duplicated until equals and hashCode are both overridden
        for (HeavenlyBody planet : planets) {
            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
        }
    }

}
