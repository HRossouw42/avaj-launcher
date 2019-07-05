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
        int n = weather.length;
        Random rand = new Random();
        int randomIndex = rand.nextInt(n);

        //TODO take height into account
        System.out.println(coordinates);
        System.out.println(weather[randomIndex]);
        return (weather[randomIndex]);
    }

}
