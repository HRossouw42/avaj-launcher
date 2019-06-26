package com.launcher.simulator.vehicles;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {

        this.longitude = longitude;
        this.latitude = latitude;

        //there's a minimum TODO
        this.height = height;
        return;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}