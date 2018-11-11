package edu.georgasouthern.oodteamguha;

import static edu.georgasouthern.oodteamguha.Algorithm.Costs;

public class Input_Object {
    double value;
    String name;
    boolean monthly;

    //from Initial_Startup_1 & 2
    Input_Object(String name, double cost, boolean monthly){
    this.value = cost;
    this.monthly = monthly;
    this.name = name;
    Costs.add(this);
    }

    //alternately, can make child classes for monthly and non-monthly essentials


}
