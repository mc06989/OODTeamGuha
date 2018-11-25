package activities;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.R;

public class ExpenseListViewHolder extends RecyclerView.ViewHolder {
    public ExpenseListViewHolder(View itemView) {
        super(itemView);
    }

    @SuppressLint("SetTextI18n")
    public void setData(TableDefinitions.Expense item) {
        android.widget.TextView name = itemView.findViewById(R.id.expense_tag_name);
        name.setText(item.getName());
        android.widget.TextView amount = itemView.findViewById(R.id.expense_tag_value);
        amount.setText(Double.toString(item.getValue()));
    }
}
