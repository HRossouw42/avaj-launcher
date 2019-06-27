package com.launcher.simulator.vehicles;

import com.launcher.weather.WeatherTower;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}
