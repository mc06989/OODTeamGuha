package edu.georgasouthern.oodteamguha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.j256.ormlite.android.apptools.OpenHelperManager;

public class Startup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        System.out.print("Simulating startup");

        Intent intent = new Intent(getApplicationContext(), DatabaseTest.class);
        startActivity(intent);
        finish();
    }
}
