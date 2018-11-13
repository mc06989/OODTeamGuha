package edu.georgasouthern.oodteamguha;

//Used to store the adjusted balances for each year

public class DataInterval {
    private int year;
    private double adjustedBalance;

    public DataInterval(int year, double adjustedBalance) {
        this.year = year;
        this.adjustedBalance = adjustedBalance;
    }

    public DataInterval() {

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAdjustedBalance() {
        return adjustedBalance;
    }

    public void setAdjustedBalance(double adjustedBalance) {
        this.adjustedBalance = adjustedBalance;
    }
}
