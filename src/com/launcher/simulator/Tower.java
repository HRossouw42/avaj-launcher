package com.launcher.simulator;

import com.launcher.simulator.vehicles.Flyable;

import java.io.Flushable;
import java.util.ArrayList;

// Purpose -> checks if aircraft are flying and registers / unregisters them

public class Tower {
    //Methods, variables, and constructors that are declared private
    //can only be accessed within the declared class itself.

    // ArrayList inherits AbstractList class and implements List interface.
    // ArrayList can not be used for primitive types, like int, char, etc. We need a wrapper class for such cases
    // https://www.geeksforgeeks.org/arraylist-in-java/
    private ArrayList<Flyable> observers = new ArrayList<Flyable>();
    private ArrayList<Flyable> obscured = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        //TODO error check
        observers.add(flyable);
        System.out.print(flyable + "is added to flying");
    }

    public void unregister(Flyable flyable) {
        //TODO error check
        obscured.add(flyable);
        System.out.print(flyable + "is added to obscured");

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
        for (Flyable flyable : observers) {
            System.out.print(flyable);
            flyable.updateConditions();
            // remove all elements found in a list from another list
            // http://tutorials.jenkov.com/java-collections/list.html
        }
        observers.removeAll(obscured);
        System.out.print(obscured + "removed from flyables");

    }
}
