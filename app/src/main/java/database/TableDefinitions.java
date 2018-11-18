package database;
import android.icu.util.DateInterval;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.types.DateTimeType;
import com.j256.ormlite.table.DatabaseTable;

public abstract class TableDefinitions {


    @DatabaseTable(tableName = "UserData")
    public static class User{
        @DatabaseField(canBeNull = false, defaultValue = "User")
        public String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {

            return name;
        }

        public User(){

        }
    }



    @DatabaseTable(tableName = "Expenses")
    public static class Expense {
        @DatabaseField(generatedId = true)
        private int id;
        @DatabaseField(canBeNull = false)
        private double value;
        @DatabaseField(canBeNull = true)
        private String name;
        @DatabaseField(canBeNull = false)
        private boolean monthly;


        public Expense() {

        }

        public Expense(double value, String name, boolean monthly) {
            this.value = value;
            this.name = name;
            this.monthly = monthly;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

    @DatabaseTable(tableName = "AccountTypes")
    public static class AccountType{

        @DatabaseField(generatedId = true)
        private int id;
        @DatabaseField(canBeNull = false)
        private String name;

        public AccountType(){

        }

        public AccountType(String name){
            this.name=name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    @DatabaseTable(tableName = "Accounts")
    public static class Account{

        @DatabaseField(generatedId = true)
        private int id;
        @DatabaseField(canBeNull = false)
        private String name;
        @DatabaseField(canBeNull = false, defaultValue = "0.0", dataType = DataType.DOUBLE)
        private double balance;
        @DatabaseField(canBeNull = false)
        private AccountType accountType;

        public Account(){

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public AccountType getAccountType() {
            return accountType;
        }

        public void setAccountType(AccountType accountType) {
            this.accountType = accountType;
        }
    }

    @DatabaseTable(tableName = "SavingsAccounts")
    public static class SavingsAccount{
        @DatabaseField(foreign = true)
        private Account account;
        @DatabaseField(canBeNull = false)
        private double interestRate;

        public SavingsAccount(){

        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }
    }

    @DatabaseTable(tableName = "Incomes")
    public static class Income{
        @DatabaseField(id=true,generatedId = true)
        private int id;
        @DatabaseField(canBeNull = true)
        private int amount;
        @DatabaseField(canBeNull = true)
        private String name;

        public Income(){

        }

        public Income(String name, int amount){
            this.name=name;
            this.amount=amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
