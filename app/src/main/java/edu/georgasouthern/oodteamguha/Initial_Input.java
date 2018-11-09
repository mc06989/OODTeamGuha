package edu.georgasouthern.oodteamguha;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Initial_Input extends AppCompatActivity {

    EditText a,b,c,d,e,f,g,h,i;
    ArrayList<Input_Object> Costs;

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

        Costs.add(new Input_Object(a.getTransitionName() ,Integer.parseInt(a.getText().toString()), true));
        Costs.add(new Input_Object(b.getTransitionName() ,Integer.parseInt(b.getText().toString()), true));
        Costs.add(new Input_Object(c.getTransitionName() ,Integer.parseInt(c.getText().toString()), true));
        Costs.add(new Input_Object(d.getTransitionName() ,Integer.parseInt(d.getText().toString()), true));
        Costs.add(new Input_Object(e.getTransitionName() ,Integer.parseInt(e.getText().toString()), true));
        Costs.add(new Input_Object(f.getTransitionName() ,Integer.parseInt(f.getText().toString()), true));
        Costs.add(new Input_Object(g.getTransitionName() ,Integer.parseInt(g.getText().toString()), true));
        Costs.add(new Input_Object(h.getTransitionName() ,Integer.parseInt(h.getText().toString()), true));
        Costs.add(new Input_Object(i.getTransitionName() ,Integer.parseInt(i.getText().toString()), true));



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
