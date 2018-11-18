package edu.georgasouthern.oodteamguha;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import algorithms.CalcBudgetUntil;
import edu.georgasouthern.oodteamguha.ui.budgetuntil.BudgetUntilFragment;

public class BudgetUntil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_until_activity);
        if (savedInstanceState == null) {
            /*getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new BudgetUntilFragment())
                    .commitNow();*/
        }


    }
}
