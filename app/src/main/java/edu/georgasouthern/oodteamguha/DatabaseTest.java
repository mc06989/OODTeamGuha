package edu.georgasouthern.oodteamguha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;
import edu.georgasouthern.oodteamguha.RecyclerItemClickListener;

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

            final List<TableDefinitions.Expense> expenses = getHelper().getExpenseDao().queryForAll();
            final DataTestAdapter adapter = new DataTestAdapter(expenses);

            final RecyclerView rv = ((RecyclerView)findViewById(R.id.recyclerView));
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            Button addButton = findViewById(R.id.addExpenseButton);

            rv.addOnItemTouchListener(new RecyclerItemClickListener(
                    getApplicationContext(),
                    rv,
                    new RecyclerItemClickListener.ClickListener(){

                        @Override
                        public void onItemClick(View view, int position) {
                            try {

                                TableDefinitions.Expense e = ((DataTestAdapter)rv.getAdapter()).getItem(position);
                                expenses.remove(e);
                                getHelper().getExpenseDao().delete(e);
                                rv.getAdapter().notifyDataSetChanged();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }
            ));

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TableDefinitions.Expense e = new TableDefinitions.Expense(10, "test", false);
                    expenses.add(e);
                    try {
                        getHelper().getExpenseDao().create(e);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    adapter.notifyDataSetChanged();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
