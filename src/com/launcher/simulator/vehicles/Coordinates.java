package com.launcher.simulator.vehicles;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {

        this.longitude = longitude;
        this.latitude = latitude;

        //there's a minimum of 0-100 for height
        if (height > 100) {
            this.height = 100;
        } else if (height < 0) {
            this.height = 0;
        } else {
            this.height = height;
        }

        //System.out.println("Coordinates: " + longitude + " " + latitude + " " + height);
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
