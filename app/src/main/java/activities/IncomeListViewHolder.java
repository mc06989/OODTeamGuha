package activities;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.R;

class IncomeListViewHolder extends RecyclerView.ViewHolder {
    public IncomeListViewHolder(View itemView) {
        super(itemView);
    }

    @SuppressLint("SetTextI18n")
    public void setData(TableDefinitions.Income item) {
        android.widget.TextView name = itemView.findViewById(R.id.income_tag_name);
        name.setText(item.getName());
        android.widget.TextView amount = itemView.findViewById(R.id.income_tag_value);
        amount.setText(Double.toString(item.getAmount()));
    }
}
