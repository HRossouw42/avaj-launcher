package com.launcher.simulator.vehicles;

import com.launcher.weather.WeatherTower;
//import com.launcher.simulator.vehicles.Flyable;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.println("Helicopter updated");
        //setup empty strings
        String shoutRegister = "";
        String shoutUnregister = "";

//    Helicopter#B1(1): Let's enjoy the good weather and take some pics.
        String shout = "Helicopter#" + this.name + "(" + this.id + "): ";
        shoutRegister = "Tower -> Helicopter#" + this.name + "(" + this.id + ") has registered to a weather tower.\n";
        shoutUnregister = "Tower -> Helicopter#" + this.name + "(" + this.id + ") has landed and unregistered.\n";

        String weather = weatherTower.getWeather(this.coordinates);
        weatherTower.register(this);

        //TODO remove println
        System.out.println("Helicopter" + this.name + " " + this.id);
        switch (weather) {

            case "SUN":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 10,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 2
                );
                shoutRegister = shout + "Praise the sun! We're going long.\n";
                break;

            case "RAIN":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 5,
                        coordinates.getLatitude(),
                        coordinates.getHeight()
                );
                shoutRegister = shout + "Getting rain on my choppers.\n";
                break;

            case "FOG":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 1,
                        coordinates.getLatitude(),
                        coordinates.getHeight()
                );
                shoutRegister = shout + "I ain't afraid of no fog.\n";
                break;

            case "SNOW":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 12
                );
                shoutRegister = shout + "Gotta de-ice the rotors!\n";
                break;

        }

        weatherTower.writeToFile("write", shoutRegister);

        //when landing below 0 height, unregister
        if (this.coordinates.getHeight() <= 0) {
            weatherTower.writeToFile("write", shoutUnregister);
            weatherTower.unregister(this);
        }


    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        String shoutRegister = "Tower -> Helicopter#" + this.name + "(" + this.id + ") has registered to a weather tower.\n";

        weatherTower.register(this);
        weatherTower.writeToFile("write", shoutRegister);


    }
}

