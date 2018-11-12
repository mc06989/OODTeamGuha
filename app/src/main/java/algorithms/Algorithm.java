package algorithms;

import java.util.ArrayList;

import edu.georgasouthern.oodteamguha.Input_Object;

public class Algorithm {

    static public ArrayList<Input_Object> Costs;
    static public double fixed_savings, expendable_savings, total_savings;
    static public double inflow, spending;

    //method to calculate the average of non-monthly essentials for every month
    public double cost(){
        double Avg_Non_Essential_Costs = 0;
        for(int i = 0 ; i < Costs.size(); i++){
            if(!Costs.get(i).isMonthly()){
                Avg_Non_Essential_Costs = Avg_Non_Essential_Costs + Costs.get(i).getValue();
            }
        }
        return Avg_Non_Essential_Costs;
    }


}
