package com.launcher.simulator.vehicles;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates position = new Coordinates(longitude, latitude, height);

        try {
            switch (type) {
                case "Helicopter":
                    return new Helicopter(name, position);
                case "JetPlane":
                    return new JetPlane(name, position);
                case "Baloon":
                    return new Baloon(name, position);
                default:
                    System.out.println("ERROR: Supported types are Helicopter, Jetplane, Baloon.");
                    System.exit(1);
            }
        } catch (Exception e) {
            System.out.println("ERROR: File Corrupt. Check aircraft spelling");
        }
        return null;
    }
}
