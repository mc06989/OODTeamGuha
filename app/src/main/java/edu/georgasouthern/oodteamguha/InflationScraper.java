package edu.georgasouthern.oodteamguha;

import android.content.Context;
import android.widget.TextView;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class InflationScraper implements Scraper {
    private String website;
    private String cssClassIdentifier;
    private StringBuilder builder;
    private TextView result;

    private String parseRow;
    private String parseColumn;
    private static List<DataEntry> entries;
    private GraphView graphview;

    public InflationScraper(GraphView graphview, TextView result, StringBuilder builder, String website, String cssClassIdentifier, String parseRow, String parseColumn){
        this.result = result;
        this.builder = builder;
        this.website = website;
        this.cssClassIdentifier = cssClassIdentifier;
        this.parseRow = parseRow;
        this.parseColumn = parseColumn;
        this.graphview = graphview;
    }

    public InflationScraper(TextView result, Context context){
        this(null,result,new StringBuilder(),"https://www.inflationtool.com/indian-rupee",
                ".table.table-bordered.table-hover tr","tr:matches(\\d+)","td:matches(\\d+)");
    }

    public void scrapeData(){
        try {
            Document doc = Jsoup.connect(this.getWebsite()).ignoreContentType(true).get();
            Elements fulltable = doc.select(this.getCssClassIdentifier());
            Elements eachrow = fulltable.select(this.parseRow);
            Elements eachcolumn = eachrow.select(this.parseColumn);

            List<String> matchedColumns = eachcolumn.eachText();

            this.getBuilder().append("Balance Left After Specified Period").append("\n");

            entries = new ArrayList<>();

            //Store all previous Inflation data to a list
            int j = 0;
            for (int i = 0; i < matchedColumns.size(); i += 2) {
                //Create data entry objects and add them to arraylist
                DataEntry e = new DataEntry();
                e.setYear(Integer.parseInt(matchedColumns.get(i)));
                e.setValue(Double.parseDouble(matchedColumns.get(i + 1).replaceAll("[,]", "")));
                if (j == 0) {
                    e.setInflationrate(0.0);
                } else {
                    e.setInflationrate(Math.round((((e.getValue() - entries.get(j - 1).getValue()) / entries.get(j - 1).getValue()) * 100.0) * 100.0) / 100.0);
                }
                entries.add(e);

                j++;
            }

        } catch (IOException e) {
            this.getBuilder().append("Error : ").append(e.getMessage()).append("\n");
            e.printStackTrace();
        }
    }


    public void getAdjustedBalanceGraph(GraphView graphview, double initialAmt, int endDate){
        int timeInterval = endDate - (entries.size()-1);

        System.out.println("End Date "+endDate);
        System.out.println("StartDate" + entries.get(entries.size()-1).getYear());

        System.out.println("Time Interval: "+timeInterval);

        //Scrapedata method
    //    scrapeData();

        //repaste here if it doesn't work

        //Get average inflation over specified time interval
        double endValue = entries.get(entries.size()-1).getValue();
        double startValue = entries.get(entries.size()-1-timeInterval).getValue();

        double rateOverTime = endValue/startValue;

        System.out.println(rateOverTime);

        double inflationModifier = 1.0/timeInterval;

        System.out.println(inflationModifier);

        double annualInflationRate = Math.pow(rateOverTime,inflationModifier)-1; //gives a decimal

        System.out.println("annual inflation: "+annualInflationRate);

        //Create a list of projected balances
        List<DataInterval> graphPoints = new ArrayList<>();
        graphPoints.add(new DataInterval(entries.get(entries.size()-1).getYear(),initialAmt));
        double percentageModifier = 1.0 - annualInflationRate;
        for(int i = 0; i < timeInterval; i++){
            DataInterval point = new DataInterval();
            point.setYear(entries.get(entries.size()-1).getYear()+i+1);
            initialAmt = initialAmt * percentageModifier;
            point.setAdjustedBalance(initialAmt);
            graphPoints.add(point);
        }
        System.out.println("Graph points size:" + graphPoints.size());
        NumberFormat balanceFormatter = new DecimalFormat("#0.00");

        this.getBuilder().append("$"+balanceFormatter.format(graphPoints.get(graphPoints.size()-1).getAdjustedBalance())+"\n\n");

        this.getBuilder().append("Annual Inflation Rate For Interval: \n").append(balanceFormatter.format(annualInflationRate)+"%\n\n");

        //Populate a list of Data Points for the GraphSeries
        List<DataPoint> points = new ArrayList<>();
        for (int i = 0; i < graphPoints.size(); i++) {
            DataPoint dp = new DataPoint(graphPoints.get(i).getYear(), graphPoints.get(i).getAdjustedBalance());
            points.add(dp);
        }


        //Convert List to an array for GraphSeries arg.
        DataPoint[] arraypoints = new DataPoint[points.size()];

        //Copy the points arraylist to the new array
        arraypoints = points.toArray(arraypoints);

        //Graph padding from screen edges
        graphview.getGridLabelRenderer().setPadding(25);

        //Create a format a linegraph series
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(arraypoints);
        graphview.addSeries(series);
        graphview.setTitle("Inflation Rates 1960-Present");
        graphview.setTitleTextSize(50);
        graphview.getGridLabelRenderer().setPadding(50);
        graphview.getViewport().setXAxisBoundsManual(true);
        graphview.getGridLabelRenderer().setNumHorizontalLabels(12);

        graphview.getGridLabelRenderer().isHumanRoundingX();
        graphview.getGridLabelRenderer().setHorizontalLabelsAngle(70);

        //Sets spacing for data labels
        graphview.getGridLabelRenderer().setLabelsSpace(45);

        //Get rid of comma seperators in year format
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);

        graphview.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(nf, nf) {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x vals
                    return super.formatLabel((int) value, isValueX);
                } else {
                    // show percentage for y vals
                    return "\u20B9"+ super.formatLabel((int) value, isValueX);
                }
            }
        });

    }

    @Override
    public List getEntries() {
        return this.entries;
    }

    public static List getEntriesStatic(){return entries; }

    @Override
    public StringBuilder getBuilder() {
        return this.builder;
    }

    @Override
    public String getWebsite() {
        return this.website;
    }

    @Override
    public String getCssClassIdentifier() {
        return this.cssClassIdentifier;
    }

    @Override
    public TextView getResult() {
        return this.result;
    }

    public void setResultText(String resultText) { result.setText(resultText); }
}
