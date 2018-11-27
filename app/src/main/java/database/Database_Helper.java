package database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.GenericRawResults.*;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.stmt.PreparedQuery;
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
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, TableDefinitions.User.class);
            TableUtils.createTable(connectionSource, TableDefinitions.Expense.class);
            TableUtils.createTable(connectionSource, TableDefinitions.Income.class);
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

    public int addExpenses(boolean consider_income) throws java.sql.SQLException {

// get our query builder from the DAO
        QueryBuilder<TableDefinitions.Expense, Integer> queryBuilder =
                expenseDao.queryBuilder();
        queryBuilder.selectRaw("SUM(VALUE)");
        Where <TableDefinitions.Expense, Integer> where = queryBuilder.where();
        where.eq(MONTHLY, consider_income);
        String results = expenseDao.queryRaw(queryBuilder.prepareStatementString()).toString();

        int exp = Integer.parseInt(results);
        return exp;
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

    public void addIncome() throws java.sql.SQLException {
        QueryBuilder<TableDefinitions.Income, Integer> queryBuild =
                   getIncomeDao().queryBuilder();

        RawRowMapper<Integer> mapper = new RawRowMapper<Integer>() {
            public Integer mapRow(String[] columnNames, String[] resultColumns) {
                // maybe you should verify that there _is_ only 1 column here
                // maybe you should handle the possibility of a bad number and throw
                return Integer.parseInt(resultColumns[0]);
            }
        };
        GenericRawResults<Integer> rawResults = getIncomeDao().queryRaw(
                        queryBuild.selectColumns("VALUE").prepareStatementString(), mapper);
        List<Integer> list = rawResults.getResults();
        Log.d("DATABASE_TESTING", list.toString());


// get our query builder from the DAO
        //QueryBuilder<TableDefinitions.Income, Integer> queryBuilder =
          //      getIncomeDao().queryBuilder();
       // queryBuilder.selectRaw("SUM(incomes.VALUE)");

//        String results = getIncomeDao().queryRaw(queryBuilder.prepareStatementString());

       // String results = getIncomeDao().queryRaw("select value from incomes").getFirstResult()[0];
       // Log.d("DATABASE_TESTING", results);
        //int inc = Integer.parseInt(results);
      //  return inc;
    }
    public static void main(String [] args)
    {
       // addExpenses();

    }
}
