package edu.georgasouthern.oodteamguha;
import com.j256.ormlite.field.DatabaseField;
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
        int id;
        @DatabaseField(canBeNull = false)
        double value;
        @DatabaseField(canBeNull = true)
        String name;
        @DatabaseField(canBeNull = false)
        boolean monthly;

        public Expense() {

        }

        public Expense(double value, String name, boolean monthly) {
            this.value = value;
            this.name = name;
            this.monthly = monthly;
        }
    }
}
