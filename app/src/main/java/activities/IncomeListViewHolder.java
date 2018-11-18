package activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.R;

public class IncomeListViewHolder extends RecyclerView.ViewHolder {
    public IncomeListViewHolder(View itemView) {
        super(itemView);
    }

    public void setData(TableDefinitions.Income item){
        android.widget.TextView name = itemView.findViewById(R.id.income_tag_name);
        name.setText(item.getName());
        android.widget.TextView amount = itemView.findViewById(R.id.income_tag_value);
        amount.setText(Double.toString(item.getAmount()));
    }
}
