package edu.georgasouthern.oodteamguha;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Database_Helper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "information.db";
    private static final int DB_VERSION = 1;
    private Dao<TableDefinitions.User, Integer> informationDao;
    private Dao<TableDefinitions.Expense, Integer> expenseDao;

    public Database_Helper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, TableDefinitions.User.class);
            TableUtils.createTable(connectionSource, TableDefinitions.Expense.class);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }


    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource, TableDefinitions.User.class, true);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        onCreate(database, connectionSource);
    }



    public Dao<TableDefinitions.User, Integer> getUserDao() throws SQLException,
            java.sql.SQLException {
        if (informationDao == null) {
            informationDao = getDao(TableDefinitions.User.class);
        }
        return informationDao;
    }

    public Dao<TableDefinitions.Expense, Integer> getExpenseDao() throws SQLException,
            java.sql.SQLException {
        if (expenseDao == null) {
            expenseDao = getDao(TableDefinitions.Expense.class);
        }
        return expenseDao;
    }
}
