package fragments;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.R;

public class AddExpenseDialogFragment extends DialogFragment {

    View v;
    private OnDialogCloseListener listener;

    public AddExpenseDialogFragment() {

    }

    public static AddExpenseDialogFragment newInstance(String title) {
        AddExpenseDialogFragment newDialog = new AddExpenseDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        newDialog.setArguments(args);
        return newDialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnDialogCloseListener) {
            listener = (OnDialogCloseListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDialogCloseListener");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.add_expense_dialog, container, false);

        Button ok = v.findViewById(R.id.expense_ok_button);
        Button cancel = v.findViewById(R.id.expense_cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = v.findViewById(R.id.expense_name_edit);
                EditText amount = v.findViewById(R.id.expense_amount_edit);
                CheckBox monthly = v.findViewById(R.id.expense_monthly_edit);

                TableDefinitions.Expense e = new TableDefinitions.Expense(Integer.valueOf(amount.getText().toString()), name.getText().toString(), monthly.isChecked());
                listener.OnDialogClose(e);



                dismiss();
            }
        });
        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public interface OnDialogCloseListener {
        void OnDialogClose(TableDefinitions.Expense e);
    }
}
