package com.launcher.simulator;

import com.launcher.simulator.vehicles.Flyable;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

// Purpose -> checks if aircraft are flying and registers / unregisters them

public class Tower {
    /*
    Methods, variables, and constructors that are declared private
    can only be accessed within the declared class itself.

    ArrayList inherits AbstractList class and implements List interface.
    ArrayList can not be used for primitive types, like int, char, etc. We need a wrapper class for such cases
    https://www.geeksforgeeks.org/arraylist-in-java/
    */
    private ArrayList<Flyable> flyingList = new ArrayList<Flyable>();
    private ArrayList<Flyable> landedList = new ArrayList<Flyable>();

    /*
    https://www.tutorialspoint.com/java/java_filewriter_class.htm
    create file variable and FileWriter Object
    */
    private File file;
    private FileWriter writer;

    public void register(Flyable flyable) {
        //error check to see if list contains
        if (flyingList.contains(flyable))
            return;
        flyingList.add(flyable);
        //System.out.println(flyable + " is added to flying");
    }

    public void unregister(Flyable flyable) {
        if (landedList.contains(flyable))
            return;
        landedList.add(flyable);
        //System.out.println(flyable + " is added to obscured");
    }

    protected void conditionsChanged() {
         /*
         enhanced for loop - for(declaration : expression)
         Declaration − The newly declared block variable, is of a type compatible with the elements
         of the array you are accessing. The variable will be available within the for block
         and its value would be the same as the current array element.

         Expression − This evaluates to the array you need to loop through.
         The expression can be an array variable or method call that returns an array.
          */
        for (Flyable flyable : flyingList) {
            //System.out.println("Flyable observed");
            flyable.updateConditions();
        }
        // remove all elements found in a list from another list
        // http://tutorials.jenkov.com/java-collections/list.html
        flyingList.removeAll(landedList);
    }

    // https://www.tutorialspoint.com/java/java_filewriter_class.htm
    // https://www.tutorialspoint.com/java/java_files_io.htm
    public void writeToFile(String state, String text) {
        try {
            this.file = new File("simulation.txt");
            this.file.createNewFile();
            this.writer = new FileWriter(file, true);
            switch (state) {
                case "write":
                    try {
                        writer.write(text);
                        writer.flush();
                    } catch (Exception e) {
                        System.out.println("Error: Cannot write to file");
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: Cannot write to file");
        }
    }
}
