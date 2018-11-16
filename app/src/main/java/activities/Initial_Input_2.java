package activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.georgasouthern.oodteamguha.R;

import static algorithms.Algorithm.expendable_savings;
import static algorithms.Algorithm.extra_income;
import static algorithms.Algorithm.fixed_savings;
import static algorithms.Algorithm.pension_income;
import static algorithms.Algorithm.saving_from_income;
import static algorithms.Algorithm.setExpendable_income;
import static algorithms.Algorithm.setExpendable_savings;
import static algorithms.Algorithm.setExtra_income;
import static algorithms.Algorithm.setFixed_savings;
import static algorithms.Algorithm.setFixed_savings_interest;
import static algorithms.Algorithm.setPension_income;
import static algorithms.Algorithm.setSaving_from_income;
import static algorithms.Algorithm.setTotal_savings;
import static algorithms.Algorithm.total_savings;
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

                //income
                EditText Pension = findViewById(R.id.pensionmoney);
                setPension_income(Double.parseDouble(Pension.getText().toString()));
                EditText SavingsFromInc = findViewById(R.id.savingsFromIncome);
                setSaving_from_income(Double.parseDouble(SavingsFromInc.getText().toString()));
                EditText ExtraInc = findViewById(R.id.extramonies);
                setExtra_income(Double.parseDouble(ExtraInc.getText().toString()));

                setExpendable_income();

                //savings
                EditText Fixed = findViewById(R.id.balanceEditText);
                EditText Expendable = findViewById(R.id.incomeEditText);
                EditText Fixed_Interest = findViewById(R.id.interest);

                setFixed_savings(Double.parseDouble(Fixed.getText().toString()));
                System.out.println("fixed savings created");
                setExpendable_savings(Double.parseDouble(Expendable.getText().toString()));
                setFixed_savings_interest(Double.parseDouble(Fixed_Interest.getText().toString()));
                setTotal_savings();

                    }
                    });

    }

}
