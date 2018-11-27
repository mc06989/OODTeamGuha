package edu.georgasouthern.oodteamguha.ui.budgetuntil;

import android.app.FragmentManager;
import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;

import algorithms.CalcBudgetUntil;
import database.Database_Helper;
import edu.georgasouthern.oodteamguha.R;

import static database.Database_Helper.getHelper;

@SuppressWarnings("FieldCanBeLocal")
public class BudgetUntilFragment extends Fragment {

    RecyclerView rv;


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
        //  rv = getActivity().findViewById(R.id.recyclerView2);
    }


    public void onStart() {
        super.onStart();
        //FIX THIS
        Button calc = getActivity().findViewById(R.id.button2);
        //rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        calc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FragmentManager fm = getFragmentManager();
                // CalcBudgetUntil.LastUntil(2018);
                TextView show = getActivity().findViewById(R.id.textView11);
               // TextView last = getActivity().findViewById(R.id.lastuntil);
                double costs = 0;
                try {
                   costs = Database_Helper.getHelper(getContext()).expensesum();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                double income = 0;
                try {
                    income = Database_Helper.getHelper(getContext()).Incomesum();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                double balance;
                balance = income - costs;
                if(balance < 0) { show.append("You are " + balance + " rupees out of budget!");}
                if (balance == 0){  show.append("Your budget is exactly 0. Make sure to account for all your expenses! ");}
                if (balance > 0){  show.append("Your current monthly balance, \n with " + costs +
                        " rupees being spent and \n " + income + " rupees coming in is " + balance); }


                /*//ArrayList<String> lasting  = new ArrayList<String>();
                int year = 2018;
                double monthlyBal = balance;
                //considering essential-yearly costs too
               if (monthlyBal < 0) last.append("Your budget will not last you this month!");
                else {
                    last.append("Your budget will last in" + year);
                    System.out.println("Your budget will last in " + year);

                    for(int r = year + 1; r < year + 80; r++){
                        double hm = CalcBudgetUntil.rateFromYear(r)/100 + 1;
                        double costss =  costs*hm;
                        last.append("       hm is   " + Double.toString(hm) + "    ");
                        double incomee = income*(1 - CalcBudgetUntil.rateFromYear(r));
                        //Base case when budget does not last
                        if((incomee - costss) < 0 ){ break; }
                        else {
                            last.append("Your budget has a balance of " + (income - costs) + " for the year " + r);
                           // System.out.println("Your budget has a balance of " + (income - costs) + " for the year " + year );
                        }
                    }
                }
                //show.append("sdcdscdsc");*/
            }
        });
    }

    public void onResume(){
        super.onResume();

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void onSaveInstanceState(Bundle out){
        super.onSaveInstanceState(out);
    }
}