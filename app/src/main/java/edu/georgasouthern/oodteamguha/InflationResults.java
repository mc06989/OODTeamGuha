package edu.georgasouthern.oodteamguha;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;

public class InflationResults extends Activity {
    private final StringBuilder builder = new StringBuilder();
    private TextView result;
    private GraphView graphview;

    //trying to run inflationScraper as a service lol.


    public GraphView getGraphview() {
        return graphview;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_view);
        result = findViewById(R.id.result);
        graphview = findViewById(R.id.getGraphView);

        Bundle inputs;
        inputs = getIntent().getExtras();

        double initialAmt = Double.parseDouble(inputs != null ? inputs.getString("initialAmtEditText") : null);
        int startDate = Integer.parseInt(inputs != null ? inputs.getString("startDateEditText") : null);
        int endDate = Integer.parseInt(inputs != null ? inputs.getString("endDateEditText") : null);

        getAdjustedBalance(graphview, initialAmt, startDate, endDate);

    }

    private void getAdjustedBalance(final GraphView graphview, final double initialAmt, final int startDate, final int endDate) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                InflationScraper scraper = new InflationScraper(graphview, result, builder, "https://www.inflationtool.com/indian-rupee",
                        ".table.table-bordered.table-hover tr", "tr:matches(\\d+)", "td:matches(\\d+)");

                scraper.getAdjustedBalanceGraph(graphview, initialAmt, endDate);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(builder.toString());
                    }
                });
            }
        }).start();
    }
}
