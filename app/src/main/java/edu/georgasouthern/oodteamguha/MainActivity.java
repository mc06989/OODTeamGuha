package edu.georgasouthern.oodteamguha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation);

        Button createButton = findViewById(R.id.button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText balanceEditText = findViewById(R.id.balanceEditText);
                EditText incomeEditText = findViewById(R.id.incomeEditText);
                EditText expensesEditText = findViewById(R.id.expensesEditText);
                TextView budgetTextView = findViewById(R.id.budgetTextView);
                if (incomeEditText.toString()=="" || expensesEditText.toString()==""||expensesEditText.toString()==""){}else{
                double income = Double.parseDouble(incomeEditText.getText().toString());
                double expenses = Double.parseDouble(expensesEditText.getText().toString());
                double balance = Double.parseDouble(balanceEditText.getText().toString());
                if (income>expenses){
                    budgetTextView.setText("Your budget will work indefinitely, make sure to account for other expenses!");
                }else if (expenses>income){

                }

                //budgetTextView.setText( Double.toString((balance/(income-expenses))/12.0) );

                }
            }
        });
    }
}
