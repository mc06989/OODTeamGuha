package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.georgasouthern.oodteamguha.CalculateInflation;
import edu.georgasouthern.oodteamguha.InflationResults;
import edu.georgasouthern.oodteamguha.Input_Object;
import edu.georgasouthern.oodteamguha.R;

public class Initial_Input extends AppCompatActivity {

    EditText a,b,c,d,e,f,g,h,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial__input);

        Button hey = findViewById(R.id.setcont);
        hey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = findViewById(R.id.foodmonies);
                b = findViewById(R.id.travelmonies);
                c = findViewById(R.id.othermonies);
                d = findViewById(R.id.cablemonies);
                e = findViewById(R.id.entertainmentmonies);
                f = findViewById(R.id.neothermonies);
                g = findViewById(R.id.lightbill);
                h = findViewById(R.id.waterbill);
                i = findViewById(R.id.nmeothermonies);

                new Input_Object("food" ,Integer.parseInt(a.getText().toString()), true);
                new Input_Object("travel" ,Integer.parseInt(b.getText().toString()), true);
                new Input_Object("ess_other" ,Integer.parseInt(c.getText().toString()), true);
                new Input_Object("cable" ,Integer.parseInt(d.getText().toString()), true);
                new Input_Object("entertainment" ,Integer.parseInt(e.getText().toString()), true);
                new Input_Object("noness_other" ,Integer.parseInt(f.getText().toString()), true);
                new Input_Object("light",Integer.parseInt(g.getText().toString()), false);
                new Input_Object("water",Integer.parseInt(h.getText().toString()), false);
                new Input_Object( "other",Integer.parseInt(i.getText().toString()), false);

                //go to second setup page
                Intent intent = new Intent(Initial_Input.this, Initial_Input_2.class);
                startActivity(intent);


            }
        });
    }

}
