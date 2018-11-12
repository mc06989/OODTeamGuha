package edu.georgasouthern.oodteamguha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculateInflation extends Activity {
    private Button getBtn;
    private final StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_inflation);
        getBtn = (Button) findViewById(R.id.getBtn);

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get Text Fields
                EditText initialAmtEditText = (EditText) findViewById(R.id.initialAmountEditText);
                EditText startDateEditText = (EditText) findViewById(R.id.startDateEditText);
                EditText endDateEditText = (EditText) findViewById(R.id.endDateEditText);

                //Start your second activity
                Intent intent = new Intent(CalculateInflation.this, InflationResults.class);
                intent.putExtra("initialAmtEditText",initialAmtEditText.getText().toString());
                intent.putExtra("startDateEditText",startDateEditText.getText().toString());
                intent.putExtra("endDateEditText",endDateEditText.getText().toString());
                startActivity(intent);
            }
        });
    }

}
