package activities;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.R;

public class DataTestViewHolder extends ViewHolder {


    public DataTestViewHolder(View itemView) {
        super(itemView);
    }

    public void setData(TableDefinitions.Expense item){
        android.widget.TextView name = itemView.findViewById(R.id.DataTestName);
        name.setText(item.getName());
        android.widget.TextView amount = itemView.findViewById(R.id.DataTestAmount);
        amount.setText(Double.toString(item.getValue()));
    }
}

