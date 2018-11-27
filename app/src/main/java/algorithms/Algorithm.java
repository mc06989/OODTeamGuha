package algorithms;

import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

import java.util.ArrayList;
import java.util.List;

import database.Database_Helper;
import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.DataEntry;
import edu.georgasouthern.oodteamguha.InflationScraper;
import edu.georgasouthern.oodteamguha.Input_Object;

import static database.TableDefinitions.Expense.MONTHLY;
import static java.security.AccessController.getContext;

public class Algorithm {

    //a list of costs
    static public ArrayList<Input_Object> Costs;

    //from initial_input_2
    static public double pension_income, extra_income, saving_from_income, expendable_income ;
    static public double fixed_savings, fixed_savings_interest, expendable_savings, total_savings;

    //need to be removed and replaced from mainactivity
    static public double inflow, spending;

    public double totalMonthlyCosts(){
       // Database_Helper.getIncomeDao();
        //TableDefinitions.Expense.class.Expense();
        return 0.00;
    }

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

    //not very useful might delete
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

    //total monthly cost
    public static double totalMonthlyCosts(boolean considerAnnual){
        double totalMonthly = 0 ;
        double totalAnnual = 0 ;
        for(int i = 0; i < Costs.size(); i++){
            if(Costs.get(i).isMonthly()== true){ totalMonthly = totalMonthly + Costs.get(i).getValue(); }
            else
                totalAnnual = totalAnnual + Costs.get(i).getValue(); }

        if (considerAnnual == true){ return(totalAnnual/12) + totalMonthly;}
        else
            return totalMonthly; }


    public double monthlyBalance (boolean considerannual){
      double costs = Database_Helper.getHelper(getContext()).expensesum(considerannual);
      double income = Database_Helper.getHelper(getContext()).Incomesum();
      double balance;
      balance = income - costs;
        if(balance < 0) { System.out.println("You are " + balance + " rupees out of budget!");}
      if (balance == 0){ System.out.println("Your budget is exactly 0. Make sure to account for all your expenses! ");}
      if (balance > 0){ System.out.println("Your current monthly balance, with " + costs +
              " rupees being spent and " + income + " rupees being spent is " + balance); }

        return balance;
    }



    }


