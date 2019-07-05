package com.launcher.simulator.vehicles;

import com.launcher.weather.WeatherTower;
//import com.launcher.simulator.vehicles.Flyable;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.println("Balloon updated");
        //setup empty strings
        String shoutRegister = "";
        String shoutUnregister = "";

//    Baloon#B1(1): Let's enjoy the good weather and take some pics.
        String shout = "Baloon#" + this.name + "(" + this.id + "): ";
        shoutRegister = "Tower -> Baloon#" + this.name + "(" + this.id + ") has registered to a weather tower.\n";
        shoutUnregister = "Tower -> Baloon#" + this.name + "(" + this.id + ") has landed and unregistered.\n";

        String weather = weatherTower.getWeather(this.coordinates);
        weatherTower.register(this);

        //TODO remove println
        System.out.println("Baloon" + this.name + " " + this.id);
        switch (weather) {
            case "RAIN":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 5);
                shoutRegister = shout + "RAIN! We're losing height!\n";
                break;

            case "SUN":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 2,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 4);
                shoutRegister = shout + "Pack some shades boys, sun's out!\n";
                break;

            case "FOG":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 3);
                shoutRegister = shout + "Fiddlesticks. This damn fog makes flying hard.\n";
                break;

            case "SNOW":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 15);
                shoutRegister = shout + "Winter has come!\n";
                break;

        }

        weatherTower.writeToFile("write", shoutRegister);

        //when landing below 0 height, unregister
        if (this.coordinates.getHeight() <= 0) {
            weatherTower.writeToFile("write", shoutUnregister);
            weatherTower.unregister(this);
        }


    }

        public void registerTower (WeatherTower weatherTower){
            this.weatherTower = weatherTower;
            String shoutRegister = "Tower -> Baloon#" + this.name + "(" + this.id + ") has registered to a weather tower.\n";

            weatherTower.register(this);
            weatherTower.writeToFile("write", shoutRegister);


        }
    }
