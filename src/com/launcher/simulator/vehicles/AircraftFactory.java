package com.launcher.simulator.vehicles;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates position = new Coordinates(longitude, latitude, height);

        switch (type) {
            case "Helicopter":
                return new Helicopter(name, position);
            case "Jetplane":
                return new JetPlane(name, position);
            case "Baloon":
                return new Baloon(name, position);
            default:
                System.out.println("ERROR: Supported types are Helicopter, Jetplane, Baloon.");
                return null;
                // see if exit needed here TODO
        }
    }
}
