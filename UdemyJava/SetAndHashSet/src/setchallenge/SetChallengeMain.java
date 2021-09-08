package setchallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetChallengeMain {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();

    public static void main(String[] args) {
        Planet temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);

        Moon tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);
        temp.addSatellite(new Moon("Moon", 45)); // this shouldn't work

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);

        // trying to add duplicate
        temp = new Planet("Mars", 322);
        solarSystem.put(temp.getKey(), temp);

        // print all heavenly bodies
        System.out.println("Planets:");
        for (HeavenlyBody.Key k : solarSystem.keySet()) {
            System.out.println("\t" + solarSystem.get(k).toString());
        }

        // print all moons
        System.out.println("Moons:");
        for (HeavenlyBody.Key k : solarSystem.keySet()) {
            for (HeavenlyBody b : solarSystem.get(k).getSatellites()) {
                System.out.println("\t" + b.toString());
            }
        }
    }
}
