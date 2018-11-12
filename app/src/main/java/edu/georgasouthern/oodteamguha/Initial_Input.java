package edu.georgasouthern.oodteamguha;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import static edu.georgasouthern.oodteamguha.Algorithm.Costs;

public class Initial_Input extends AppCompatActivity {

    EditText a,b,c,d,e,f,g,h,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial__input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        a = (EditText) findViewById(R.id.foodmonies);
        b = (EditText) findViewById(R.id.travelmonies);
        c = (EditText) findViewById(R.id.othermonies);
        d = (EditText) findViewById(R.id.cablemonies);
        e = (EditText) findViewById(R.id.entertainmentmonies);
        f = (EditText) findViewById(R.id.neothermonies);
        g = (EditText) findViewById(R.id.lightbill);
        h = (EditText) findViewById(R.id.waterbill);
        i = (EditText) findViewById(R.id.nmeothermonies);

        new Input_Object("food" ,Integer.parseInt(a.getText().toString()), true);
        new Input_Object("travel" ,Integer.parseInt(b.getText().toString()), true);
        new Input_Object("ess_other" ,Integer.parseInt(c.getText().toString()), true);
        new Input_Object("cable" ,Integer.parseInt(d.getText().toString()), true);
        new Input_Object("entertainment" ,Integer.parseInt(e.getText().toString()), true);
        new Input_Object("noness_other" ,Integer.parseInt(f.getText().toString()), true);
        new Input_Object("light",Integer.parseInt(g.getText().toString()), false);
        new Input_Object("water",Integer.parseInt(h.getText().toString()), false);
        new Input_Object( "other",Integer.parseInt(i.getText().toString()), false);



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
