package edu.georgasouthern.oodteamguha;

import static algorithms.Algorithm.Costs;

public class Input_Object {
    private double value;
    private String name;
    private boolean monthly;

    //from Initial_Startup_1 & 2
    public Input_Object(String name, double cost, boolean monthly) {
        this.value = cost;
        this.monthly = monthly;
        this.name = name;
        Costs.add(this);
    }

    //alternately, can make child classes for monthly and non-monthly essentials


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }
}
