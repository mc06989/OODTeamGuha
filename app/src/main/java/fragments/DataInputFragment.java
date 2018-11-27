package fragments;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import database.Database_Helper;

import java.sql.SQLException;
import java.util.List;

import activities.ExpenseListAdapter;
import activities.IncomeListAdapter;
import database.Database_Helper;
import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DataInputFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DataInputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataInputFragment extends Fragment implements AddExpenseDialogFragment.OnDialogCloseListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "count";
    List<TableDefinitions.Expense> expenses;// = getHelper().getExpenseDao().queryForAll();
    List<TableDefinitions.Income> incomes;
    ExpenseListAdapter expense_adapter;
    RecyclerView expense_rv;
    IncomeListAdapter income_adapter;
    RecyclerView income_rv;
    // TODO: Rename and change types of parameters
    private int count;
    private OnFragmentInteractionListener mListener;


    public DataInputFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param count Parameter 1.
     * @return A new instance of fragment DataInputFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataInputFragment newInstance(int count) {
        DataInputFragment fragment = new DataInputFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, count);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            count = getArguments().getInt(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_input, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {

            expenses = Database_Helper.getHelper(getContext()).getExpenseDao().queryForAll();
            expense_adapter = new ExpenseListAdapter(expenses);
            expense_rv = getActivity().findViewById(R.id.expense_recycler_view);
            incomes = Database_Helper.getHelper(getContext()).getIncomeDao().queryForAll();
            income_adapter = new IncomeListAdapter(incomes);
            income_rv = getActivity().findViewById(R.id.income_recycler_view);
            System.out.println(income_rv.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void onStart() {
        super.onStart();

        final Button add_expense_button = getActivity().findViewById(R.id.add_expense_button);
        final Button add_income_button = getActivity().findViewById(R.id.add_income_button);
        //DeleteBuilder<TableDefinitions.Expense, Integer> deletebuilder = getHelper().getExpenseDao().deleteBuilder();
        //getHelper().getExpenseDao().delete(deletebuilder.prepare());
            /*for (int i = 0;i<40;i++){
                TableDefinitions.Expense e = new TableDefinitions.Expense(10, "Test", false);
                getHelper().getExpenseDao().create(e);
            }*/


        expense_rv.setAdapter(expense_adapter);
        expense_rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        income_rv.setAdapter(income_adapter);
        income_rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));


        add_expense_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                DialogFragment add_expense_dialog_fragment = AddExpenseDialogFragment.newInstance("Add an expense");
                Fragment previous = getFragmentManager().findFragmentByTag("expense_dialog");

                if (previous != null) {
                    ft.remove(previous);
                }
                ft.addToBackStack(null);

                add_expense_dialog_fragment.show(ft, "expense_dialog");
                /*TableDefinitions.Expense e = new TableDefinitions.Expense(20, "added", false);
                expenses.add(e);
                expense_adapter.notifyItemInserted(expenses.size()-1);

                try {
                    getHelper().getExpenseDao().create(e);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }*/
            }
        });

        add_income_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TableDefinitions.Income i = new TableDefinitions.Income("Test", 20);
                incomes.add(i);
                income_adapter.notifyItemInserted(incomes.size() - 1);
                try {
                    Database_Helper.getHelper(getContext()).getIncomeDao().create(i);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    public void onResume() {
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
    public void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        out.putInt(ARG_PARAM1, count);
        getFragmentManager().putFragment(out, "DataInputFragment", this);
    }

    @Override
    public void OnDialogClose(TableDefinitions.Expense e) {
        Log.d("PRINTOUTS", "Adding expense");
        expenses.add(e);
        try {
            Database_Helper.getHelper(getContext()).getExpenseDao().create(e);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        expense_adapter.notifyItemInserted(expenses.size() - 1);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
