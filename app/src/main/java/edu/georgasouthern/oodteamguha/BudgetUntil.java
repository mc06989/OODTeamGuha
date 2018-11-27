package edu.georgasouthern.oodteamguha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.georgasouthern.oodteamguha.ui.budgetuntil.BudgetUntilFragment;

public class BudgetUntil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_until_activity);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, BudgetUntilFragment.newInstance())
                    .commit();
        }
    }
}
