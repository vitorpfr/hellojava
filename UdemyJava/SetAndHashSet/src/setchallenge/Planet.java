package setchallenge;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, HeavenlyBody.BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody newSatellite) {
        if (newSatellite.getKey().getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(newSatellite);
        }

        return false;
    }
}
