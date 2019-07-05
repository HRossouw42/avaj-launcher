package com.launcher.simulator;

import com.launcher.simulator.vehicles.AircraftFactory;
import com.launcher.simulator.vehicles.Flyable;
import com.launcher.weather.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyablesList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Scanning Simulations File");

        if (args.length != 1) {
            System.out.println("Failed");
            return;
        }


        // The name of the file to open.
        // In this case the first argument in java starts at [0]
        System.out.println(args[0]);
        String fileName = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();
                System.out.println("New WeatherTower: " + weatherTower);

                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0) {
                    System.out.println("Simulation count " + simulations + " invalid.");
                    System.exit(1);
                }
                System.out.println("Simulation count " + simulations);

                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(
                            line.split(" ")[0],
                            line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]),
                            Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    flyablesList.add(flyable);
                    System.out.println(flyablesList);
                }

                for (Flyable flyable : flyablesList) {
                    //System.out.println(flyable);
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++) {
                    System.out.println("Simulation # " + i);
                    weatherTower.writeToFile("write", "Simulation # " + i + "\n");
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
            System.out.println("Operation ended");
        }
    }
}
