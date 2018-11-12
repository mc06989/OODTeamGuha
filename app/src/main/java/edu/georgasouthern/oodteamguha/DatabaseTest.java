package edu.georgasouthern.oodteamguha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

public class DatabaseTest extends AppCompatActivity {

    private Database_Helper database_helper = null;
    private Database_Helper getHelper() {
        if (database_helper == null) {
            database_helper = OpenHelperManager.getHelper(this,Database_Helper.class);
        }
        return database_helper;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test);



        try {
            //getHelper().getExpenseDao().create(new TableDefinitions.Expense(20, "Test", false));

            List<TableDefinitions.Expense> expenses = getHelper().getExpenseDao().queryForAll();
            DataTestAdapter adapter = new DataTestAdapter(expenses);
            RecyclerView rv = ((RecyclerView)findViewById(R.id.recyclerView));
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
