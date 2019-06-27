package com.launcher.weather;

import com.launcher.simulator.vehicles.Coordinates;

import java.util.Random;

public class WeatherProvider {

    // the class aggregates / owns itself with this static
    private static WeatherProvider weatherProvider = new WeatherProvider();

    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        //TODO why is this supposed to be static?
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        //random number between 0-3
        Random rand = new Random();
        int n = rand.nextInt(3);

        //TODO take height into account
        return (weather[n]);
    }

}
