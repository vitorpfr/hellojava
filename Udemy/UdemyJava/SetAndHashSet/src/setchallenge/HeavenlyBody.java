package setchallenge;

/*
    Only add/edit code where it is stated in the description.
*/

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = makeKey(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody newSatellite) {
        return satellites.add(newSatellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        Key objKey = ((HeavenlyBody) obj).getKey();
        return key.equals(objKey);
    }

    @Override
    public final int hashCode() {
        return key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return (key.getName() + ": " + key.bodyType + ", " + orbitalPeriod);
    }

    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return name.hashCode() + bodyType.hashCode() + 45;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if ((obj == null) || (obj.getClass() != this.getClass())) {
                return false;
            }

            Key otherKey = (Key) obj;
            return ((this.getName().equals(otherKey.getName())) && this.getBodyType().equals(otherKey.getBodyType()));
        }

        @Override
        public String toString() {
            return (name + ": " + bodyType);
        }
    }
}