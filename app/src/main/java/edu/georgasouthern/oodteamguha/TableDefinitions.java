package edu.georgasouthern.oodteamguha;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

public class TableDefinitions {


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
}
