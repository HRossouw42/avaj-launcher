package com.launcher.simulator.vehicles;

import com.launcher.weather.WeatherTower;
//import com.launcher.simulator.vehicles.Flyable;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        //setup empty strings
        String shoutRegister;
        String shoutUnregister;

//    JetPlane#B1(1): Let's enjoy the good weather and take some pics.
        String shout = "JetPlane#" + this.name + "(" + this.id + "): ";
        shoutRegister = "Tower -> JetPlane#" + this.name + "(" + this.id + ") has registered to a weather tower.\n";
        shoutUnregister = "Tower -> JetPlane#" + this.name + "(" + this.id + ") has landed and unregistered at coordinates:"+ " LONG" + coordinates.getLongitude() + " LAT" + coordinates.getLatitude() +  "\n";

        String weather = weatherTower.getWeather(this.coordinates);
        weatherTower.register(this);

        switch (weather) {

            case "SUN":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 10,
                        coordinates.getHeight() + 2
                );
                shoutRegister = shout + "Sun's out, tactical missiles out\n";
                break;

            case "RAIN":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 5,
                        coordinates.getHeight()
                );
                shoutRegister = shout + "Eagles don't care about no rain\n";
                break;

            case "FOG":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude() + 1,
                        coordinates.getHeight()
                );
                shoutRegister = shout + "Foggy skies ahead.\n";
                break;

            case "SNOW":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 7
                );
                shoutRegister = shout + "Santa's come early boys.\n";
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
        String shoutRegister = "Tower -> JetPlane#" + this.name + "(" + this.id + ") has registered to a weather tower.\n";

        weatherTower.register(this);
        weatherTower.writeToFile("write", shoutRegister);


    }
}

