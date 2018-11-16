package algorithms;

import java.util.ArrayList;
import java.util.List;

import edu.georgasouthern.oodteamguha.DataEntry;
import edu.georgasouthern.oodteamguha.InflationScraper;
import edu.georgasouthern.oodteamguha.Input_Object;

public class Algorithm {

    //a list of costs
    static public ArrayList<Input_Object> Costs;

    //from initial_input_2
    static public double pension_income, extra_income, saving_from_income, expendable_income ;
    static public double fixed_savings, fixed_savings_interest, expendable_savings, total_savings;

    //need to be removed and replaced from mainactivity
    static public double inflow, spending;

    /*public double rateFromYear(int year){
        List<DataEntry> ent = InflationScraper.getEntries();
    }
        for(int i = 0; i < InflationScraper.entries.size(); i++){
        InflationScraper.entries.
    }*/
    //INCOME
    public static void setPension_income(double pension_income) {
        Algorithm.pension_income = pension_income;
    }

    public static double getPension_income() {
        return pension_income;
    }

    public static void setSaving_from_income(double saving_from_income) {
        Algorithm.saving_from_income = saving_from_income;
    }

    public static double getSaving_from_income() {
        return saving_from_income;
    }

    public static void setExtra_income(double extra_income) {
        Algorithm.extra_income = extra_income;
    }

    public static double getExtra_income() {
        return extra_income;
    }

    public static void setExpendable_income() {
       Algorithm.expendable_income = pension_income + extra_income - saving_from_income;
    }

    public static double getExpendable_income() {
        return expendable_income;
    }

        //SAVINGS

    public static void setFixed_savings(double fixed_savings) {
        Algorithm.fixed_savings = fixed_savings;
    }

    public static double getFixed_savings() {
        return fixed_savings;
    }

    public static void setFixed_savings_interest(double fixed_savings_interest) {
        Algorithm.fixed_savings_interest = fixed_savings_interest;
    }

    public static double getFixed_savings_interest() {
        return fixed_savings_interest;
    }

    public static void setExpendable_savings(double expendable_savings) {
        Algorithm.expendable_savings = expendable_savings;
    }

    public static double getExpendable_savings() {
        return expendable_savings;
    }

    public static void setTotal_savings() {
       Algorithm.expendable_savings = fixed_savings + expendable_savings;
    }

    public static double getTotal_savings() {
        return total_savings;
    }

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
