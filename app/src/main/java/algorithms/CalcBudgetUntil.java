package algorithms;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import edu.georgasouthern.oodteamguha.DataEntry;
import edu.georgasouthern.oodteamguha.InflationScraper;

public class CalcBudgetUntil extends Algorithm {

    int currentyear = 2018;
    int untilyear;

    //
    CalcBudgetUntil(int currentyear, int untilyear){
        this.currentyear = currentyear;
        this.untilyear = untilyear;
    }

    //to get the inflation rate of a particular year
    public static double rateFromYear(int myyear){
        double rate = 0;
        List<DataEntry> ent = InflationScraper.getEntriesStatic();
        for(int i = 0; i < ent.size(); i++){ if(ent.get(i).getYear() == myyear){ rate = ent.get(i).getInflationrate(); } }
        return rate; }

        public double valueMon(){

        return 0;
    }

    //assuming that expendable income remains the same
    public static void LastUntil(int currentyear){
       ArrayList<String> lasting  = new ArrayList<String>();
        int year = currentyear;
        double monthlyBal = monthlyBalance(true);
        //considering essential-yearly costs too
        if (monthlyBal < 0) System.out.println("Your budget will not last you this month!");
        else {
            lasting.add("Your budget will last in" + year);
            System.out.println("Your budget will last in " + year);

            for(int r = year + 1; r < year + 80; r++){
            double costs =  totalMonthlyCosts(true)*(rateFromYear(r)/100 + 1);
            double income = getExpendable_income()*(1 - rateFromYear(r));
            //Base case when budget does not last
            if((income - costs) < 0 ){ break; }
            else {
                lasting.add("Your budget has a balance of " + (income - costs) + " for the year " + year);
                System.out.println("Your budget has a balance of " + (income - costs) + " for the year " + year );
            }
            }
                }
                    }



}
