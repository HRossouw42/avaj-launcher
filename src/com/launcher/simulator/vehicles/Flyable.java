package com.launcher.simulator.vehicles;

import com.launcher.simulator.WeatherTower;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}
