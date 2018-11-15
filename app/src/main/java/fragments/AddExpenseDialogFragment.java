package fragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.georgasouthern.oodteamguha.R;

public class AddExpenseDialogFragment extends DialogFragment {

    public AddExpenseDialogFragment(){

    }

    public static AddExpenseDialogFragment newInstance(String title){
        AddExpenseDialogFragment newDialog = new AddExpenseDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        newDialog.setArguments(args);
        return newDialog;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.add_expense_dialog, container, false);

        Button cancel = v.findViewById(R.id.expense_cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
    }
}
