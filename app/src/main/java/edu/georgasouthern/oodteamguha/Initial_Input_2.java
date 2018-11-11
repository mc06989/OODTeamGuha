package edu.georgasouthern.oodteamguha;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static edu.georgasouthern.oodteamguha.Algorithm.fixed_savings;
import static edu.georgasouthern.oodteamguha.Algorithm.expendable_savings;
import static edu.georgasouthern.oodteamguha.Algorithm.total_savings;
public class Initial_Input_2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial__input_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button createButton = findViewById(R.id.TotalSav);
        createButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText Fixed = findViewById(R.id.balanceEditText);
                EditText Expendable = findViewById(R.id.incomeEditText);
                TextView TotalTextView = findViewById(R.id.Savings);

                if (Fixed.toString()=="" || Expendable.toString()==""){}else{
                    fixed_savings = Double.parseDouble(Fixed.getText().toString());
                  // new Input_Object(Fixed.getTransitionName(),fixed_savings,false);
                    expendable_savings = Double.parseDouble(Expendable.getText().toString());
                   // new Input_Object(Expendable.getTransitionName(),expendable_savings,false);
                    total_savings = fixed_savings + expendable_savings;
                        TotalTextView.setText(Double.toString(total_savings));
                    }
                    }});

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
