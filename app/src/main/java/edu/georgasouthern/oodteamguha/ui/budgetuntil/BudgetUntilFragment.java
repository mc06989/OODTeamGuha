package edu.georgasouthern.oodteamguha.ui.budgetuntil;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLException;

import activities.ExpenseListAdapter;
import algorithms.CalcBudgetUntil;
import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.R;
import fragments.AddExpenseDialogFragment;

public class BudgetUntilFragment extends Fragment {

    RecyclerView rv;


    private BudgetUntilFragment.OnFragmentInteractionListener mListener;
    private BudgetUntilViewModel mViewModel;

    public static BudgetUntilFragment newInstance() {
        return new BudgetUntilFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.budget_until_fragment, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
            rv = getActivity().findViewById(R.id.recyclerView2);
    }


    public void onStart() {
        super.onStart();
        Button calc = getActivity().findViewById(R.id.calcUntil);
        rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getFragmentManager();
                CalcBudgetUntil.LastUntil(2018);
                TextView show = getActivity().findViewById(R.id.textView11);
                show.append("sdcdscdsc");
            }
        });
    }

    public void onResume(){
        super.onResume();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onSaveInstanceState(Bundle out){
        super.onSaveInstanceState(out);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}