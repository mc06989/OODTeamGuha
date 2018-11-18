package fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;

import edu.georgasouthern.oodteamguha.InflationScraper;
import edu.georgasouthern.oodteamguha.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InflationGraphFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InflationGraphFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;


    public InflationGraphFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment InflationGraphFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InflationGraphFragment newInstance(/*String param1, String param2*/) {
        InflationGraphFragment fragment = new InflationGraphFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.graph_view, container, false);
    }

    public void onStart(){
        super.onStart();


        final TextView tv = getActivity().findViewById(R.id.result);
        new Thread(new Runnable() {
            @Override
            public void run() {

                final InflationScraper scraper = new InflationScraper(tv, getActivity().getApplicationContext());
                scraper.scrapeData();
                scraper.getAdjustedBalanceGraph((GraphView) getActivity().findViewById(R.id.getGraphView), 100,2050);


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        scraper.setResultText(scraper.getBuilder().toString());
                    }
                });
            }
        }).start();
    }

}
