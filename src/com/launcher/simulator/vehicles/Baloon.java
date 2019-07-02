package com.launcher.simulator.vehicles;

import com.launcher.weather.WeatherTower;
//import com.launcher.simulator.vehicles.Flyable;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String outRegister = "";
        String outUnregister = "";

//    Baloon#B1(1): Let's enjoy the good weather and take some pics.
        String shout = "Baloon#" + this.name + "(" + this.id + "): ";

        String weather = weatherTower.getWeather(this.coordinates);
        weatherTower.register(this);

        System.out.println("Baloon" + this.name + " " + this.id);
        switch (weather) {
            case "RAIN":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 5);
                outRegister = shout + "RAIN! We're losing height!\n";
                break;

            case "SUN":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 2,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 4);
                outRegister = shout + "Pack some shades boys, sun's out!\n";
                break;

            case "FOG":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 3);
                outRegister = shout + "Fiddlesticks. This damn fog makes flying hard.\n";
                break;

            case "SNOW":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 15);
                outRegister = shout + "Winter has come!\n";
                break;

        }

//        weatherTower.printOut()
    }

        public void registerTower (WeatherTower weatherTower){
            this.weatherTower = weatherTower;

        }
    }
