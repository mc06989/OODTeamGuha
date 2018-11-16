package algorithms;

import edu.georgasouthern.oodteamguha.DataEntry;
import edu.georgasouthern.oodteamguha.InflationResults;
import edu.georgasouthern.oodteamguha.InflationScraper;

public class CalcBudgetUntil extends Algorithm {

    int currentyear = 2018;
    int untilyear;

    CalcBudgetUntil(int currentyear, int untilyear){
        this.currentyear = currentyear;
        this.untilyear = untilyear;
    }

        /*public getInflationData()
    InflationScraper scraper = new InflationScraper(InflationResults.getGraphview(),result,builder,"https://www.inflationtool.com/indian-rupee",
            ".table.table-bordered.table-hover tr","tr:matches(\\d+)","td:matches(\\d+)");

            scraper.getAdjustedBalanceGraph(initialAmt,startDate,endDate);
*/
    public double totalCosts(){
        double totalMonthly = 0 ;
        double totalAnnual = 0 ;

        for(int i = 0; i < Costs.size(); i++){
            if(Costs.get(i).isMonthly()== true){
                totalMonthly = totalMonthly + Costs.get(i).getValue(); }
                else
                    totalAnnual = totalAnnual + Costs.get(i).getValue();
            }
            return totalAnnual + (totalMonthly*12);
        }

        public double valueMon(){

        return 0.00;
    }

   // public double CostIncrease(int year, )


}
