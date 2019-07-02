package com.launcher.simulator;

import com.launcher.simulator.vehicles.AircraftFactory;
import com.launcher.simulator.vehicles.Flyable;
import com.launcher.weather.WeatherProvider;
import com.launcher.weather.WeatherTower;
import com.launcher.simulator.vehicles.Aircraft;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Scanning Simulations File");

        if (args.length != 1) {
            System.out.println("Failed");
            return;
        }


        // The name of the file to open.
        System.out.println(args[0]);
        String fileName = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();

                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0) {
                    System.out.println("Simulation count " + simulations + " invalid.");
                    System.exit(1);
                }

                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(
                            line.split(" ")[0],
                            line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]),
                            Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++) {
                    weatherTower.changeWeather();
                }
                reader.close();
            }

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "Choose a simulation file"
            );
        } finally {
            //Logger.getLogger().close();
        }
    }


}
