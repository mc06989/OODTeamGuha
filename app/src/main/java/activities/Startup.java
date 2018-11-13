package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.georgasouthern.oodteamguha.R;

public class Startup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        System.out.print("Simulating startup");

        Intent intent = new Intent(getApplicationContext(), NavPane.class);
        startActivity(intent);
        finish();
    }
}
