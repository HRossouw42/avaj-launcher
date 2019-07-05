package com.launcher.weather;

import com.launcher.simulator.Tower;
import com.launcher.simulator.vehicles.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
//        System.out.println("Running get weather");
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}
