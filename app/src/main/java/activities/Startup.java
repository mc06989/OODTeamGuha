package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import edu.georgasouthern.oodteamguha.FirstStartup;
import edu.georgasouthern.oodteamguha.InflationScraper;
import edu.georgasouthern.oodteamguha.R;

public class Startup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        final TextView tv = new TextView(getApplicationContext());

        new Thread(new Runnable() {
            @Override
            public void run() {

                final InflationScraper scraper = new InflationScraper(tv, getBaseContext());

                scraper.scrapeData();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        scraper.setResultText(scraper.getBuilder().toString());
                    }
                });
            }
        }).start();
        //GraphView graphview, TextView result, StringBuilder builder, String website, String cssClassIdentifier, String parseRow, String parseColumn

        //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET},0);

        Intent intent = new Intent(getApplicationContext(), FirstStartup.class);
        startActivity(intent);
        finish();
    }
}
