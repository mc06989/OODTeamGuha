package fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.georgasouthern.oodteamguha.CalculateInflation;
import edu.georgasouthern.oodteamguha.InflationResults;
import edu.georgasouthern.oodteamguha.R;

public class CalculateInflationFragment extends Fragment {

    public CalculateInflationFragment() {
        // Required empty public constructor
    }

    public static CalculateInflationFragment newInstance() {
        CalculateInflationFragment fragment = new CalculateInflationFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calculate_inflation, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        Button getBtn = getActivity().findViewById(R.id.getBtn);
        final EditText initial = getActivity().findViewById(R.id.initialAmountEditText);
        final EditText endDate = getActivity().findViewById(R.id.endDateEditText);
//        getBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Get Text Fields
//                EditText initialAmtEditText = getActivity().findViewById(R.id.initialAmountEditText);
//                EditText endDateEditText = getActivity().findViewById(R.id.endDateEditText);
//
//                //Start your second activity
//                Intent intent = new Intent(CalculateInflationFragment.class, InflationResults.class);
//                intent.putExtra("initialAmtEditText", initialAmtEditText.getText().toString());
//                intent.putExtra("endDateEditText", endDateEditText.getText().toString());
//                startActivity(intent);
//            }
//        });

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SettingsFragment();
                ((SettingsFragment)fragment).setEndDate(Integer.parseInt(endDate.getText().toString()));
                ((SettingsFragment)fragment).setInitial(Integer.parseInt(initial.getText().toString()));
                //getFragmentManager().beginTransaction().replace(R.id.background, new SettingsFragment()).commit();
                boolean doesPop = getFragmentManager().popBackStackImmediate(fragment.getClass().getName(), 0);
                System.out.println("Fragment class: " + fragment.getClass().getName());
                if (!(doesPop) && getFragmentManager().findFragmentByTag(fragment.getClass().getName()) == null) {
                    System.out.println("Adding nonexistent fragment " + getFragmentManager().getBackStackEntryCount());
                    getFragmentManager().beginTransaction().replace(R.id.background, fragment, fragment.getClass().getName()).addToBackStack(fragment.getClass().getName()).commit();
                } else {
                    System.err.println("Found fragment");
                }
            }
        });

    }
}
