package edu.georgasouthern.oodteamguha;

//Store the parsed data from scraped data table

public class DataEntry {

    private int year;
    private double value;
    private double inflationrate;

    public DataEntry() {
    }

    public DataEntry(int year, double value, double inflationrate) {
        this.year = year;
        this.value = value;
        this.inflationrate = inflationrate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getInflationrate() {
        return inflationrate;
    }

    public void setInflationrate(double inflationrate) {
        this.inflationrate = inflationrate;
    }

    public String toString() {

        return "Year: " + year + "  |  Value: \u20B9" + value + "  | Inflation: " + inflationrate + "%";

    }
}
