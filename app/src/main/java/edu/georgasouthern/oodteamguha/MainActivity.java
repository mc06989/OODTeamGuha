package edu.georgasouthern.oodteamguha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import static edu.georgasouthern.oodteamguha.Algorithm.inflow;
import static edu.georgasouthern.oodteamguha.Algorithm.spending;

public class MainActivity extends AppCompatActivity {
    public double balance;
    private Database_Helper database_helper = null;
    private Database_Helper getHelper() {
        if (database_helper == null) {
            database_helper = OpenHelperManager.getHelper(this,Database_Helper.class);
        }
        return database_helper;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (database_helper != null) {
            OpenHelperManager.releaseHelper();
            database_helper = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);

        //Dao<TableDefinitions.User, Integer> userDao = getHelper().getUserDao();
        //TableDefinitions.User u = new TableDefinitions.User();
        //u.setName("Tom");
        //try {
            //userDao.createIfNotExists(u);
        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}
        Button createButton = findViewById(R.id.button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText balanceEditText = findViewById(R.id.balanceEditText);
                EditText incomeEditText = findViewById(R.id.incomeEditText);
                EditText expensesEditText = findViewById(R.id.expensesEditText);
                TextView budgetTextView = findViewById(R.id.budgetTextView);
                if (incomeEditText.toString()=="" || expensesEditText.toString()==""||expensesEditText.toString()==""){}else{
                    inflow = Double.parseDouble(incomeEditText.getText().toString());
                    spending = Double.parseDouble(expensesEditText.getText().toString());
                balance = Double.parseDouble(balanceEditText.getText().toString());
                if (inflow>spending){
                    budgetTextView.setText("Your budget will work indefinitely, make sure to account for other expenses!");
                }else if (spending>inflow){
                    int months = 0;
                    while(balance != 0){
                        balance -= spending;
                        if(balance <= 0){
                            break;
                        }
                        balance += inflow;
                        months++;
                    }
                    budgetTextView.setText("Your budget will last "+months+" more months.");
                }

                //budgetTextView.setText( Double.toString((balance/(inflow-spending))/12.0) );

                }
            }
        });
    }
}
