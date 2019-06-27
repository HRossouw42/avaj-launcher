package com.launcher.simulator.vehicles;

public class Aircraft {
    // https://www.tutorialspoint.com/java/java_modifier_types.htm

    // protected means visible to the package and all subclasses
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    // The static keyword is used to create variables
    // that will exist independently
    // of any instances created for the class.
    // Only one copy of the static variable exists regardless
    // of the number of instances of the class.

    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        this.idCounter = idCounter + 1;
        return (this.idCounter);

    }

}
