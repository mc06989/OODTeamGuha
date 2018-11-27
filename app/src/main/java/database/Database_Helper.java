package database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

import static database.TableDefinitions.Expense.MONTHLY;

public class Database_Helper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "information.db";
    private static final int DB_VERSION = 1;
    private Dao<TableDefinitions.User, Integer> informationDao;
    private Dao<TableDefinitions.Expense, Integer> expenseDao;
    private Dao<TableDefinitions.AccountType, Integer> accountTypeDao;
    private Dao<TableDefinitions.Income, Integer> incomeDao;

    public Database_Helper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private static Database_Helper database_helper = null;

    public static Database_Helper getHelper(Context context) {
        if (database_helper == null) {
            database_helper = OpenHelperManager.getHelper(context, Database_Helper.class);
        }
        return database_helper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, TableDefinitions.User.class);
            TableUtils.createTable(connectionSource, TableDefinitions.Expense.class);
            TableUtils.createTableIfNotExists(connectionSource, TableDefinitions.Income.class);
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

    public Dao<TableDefinitions.AccountType, Integer> getAccountTypeDao() throws SQLException,
            java.sql.SQLException {
        if (accountTypeDao == null) {
            accountTypeDao = getDao(TableDefinitions.AccountType.class);
        }
        return accountTypeDao;
    }

    public Dao<TableDefinitions.Income, Integer> getIncomeDao() throws SQLException,
            java.sql.SQLException {
        if (incomeDao == null) {
            incomeDao = getDao(TableDefinitions.Income.class);
        }
        return incomeDao;
    }

    public int expensesum() throws java.sql.SQLException {
        List<TableDefinitions.Expense> expenselist = getExpenseDao().queryForAll();
        int sum = 0;
        for (TableDefinitions.Expense i : expenselist)
            sum+=i.getValue();

        Log.d("DATABASE_TESTING", Integer.toString(sum));
        return sum;
    }

    public int Incomesum() throws java.sql.SQLException {
        List<TableDefinitions.Income> incomeList = getIncomeDao().queryForAll();
        int sum = 0;
        for (TableDefinitions.Income e : incomeList)
            sum+=e.getAmount();

        Log.d("DATABASE_TESTING", Integer.toString(sum));
        return sum;
    }



}