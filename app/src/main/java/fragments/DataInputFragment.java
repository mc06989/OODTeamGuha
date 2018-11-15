package fragments;

import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.stmt.DeleteBuilder;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.List;

import activities.ExpenseListAdapter;
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
public class DataInputFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "count";

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
        System.out.println("I'm in onCreate");
        if (getArguments() != null) {
            count = getArguments().getInt(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_data_input, container, false);
        return v;
    }

    private Database_Helper database_helper = null;
    private Database_Helper getHelper() {
        if (database_helper == null) {
            database_helper = OpenHelperManager.getHelper(this.getActivity().getApplicationContext(),Database_Helper.class);
        }
        return database_helper;
    }

    public void onStart(){
        super.onStart();

        Button add_expense_button = getActivity().findViewById(R.id.add_expense_button);

        try {
            DeleteBuilder<TableDefinitions.Expense, Integer> deletebuilder = getHelper().getExpenseDao().deleteBuilder();
            getHelper().getExpenseDao().delete(deletebuilder.prepare());
            /*for (int i = 0;i<40;i++){
                TableDefinitions.Expense e = new TableDefinitions.Expense(10, "Test", false);
                getHelper().getExpenseDao().create(e);
            }*/

            final List<TableDefinitions.Expense> expenses = getHelper().getExpenseDao().queryForAll();



            final ExpenseListAdapter adapter = new ExpenseListAdapter(expenses);
            final RecyclerView rv = getActivity().findViewById(R.id.recyclerView2);

            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public void onResume(){
        super.onResume();

    }*/

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
        out.putInt(ARG_PARAM1, count);
        getFragmentManager().putFragment(out,"DataInputFragment",this);
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
