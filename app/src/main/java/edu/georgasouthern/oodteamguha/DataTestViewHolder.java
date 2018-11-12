package edu.georgasouthern.oodteamguha;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class DataTestViewHolder extends ViewHolder {


    public DataTestViewHolder(View itemView) {
        super(itemView);
    }

    public void setData(TableDefinitions.Expense item){
        android.widget.TextView name = itemView.findViewById(R.id.DataTestName);
        name.setText(item.name);
        android.widget.TextView amount = itemView.findViewById(R.id.DataTestAmount);
        name.setText(Double.toString(item.value));
    }
}

