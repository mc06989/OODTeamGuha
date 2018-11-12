package edu.georgasouthern.oodteamguha;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.georgasouthern.oodteamguha.TableDefinitions.*;

public class DataTestAdapter extends Adapter {

    List<Expense> listData;

    public DataTestAdapter(List<Expense> data){
        this.listData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_tag, parent, false);
        DataTestViewHolder datatestviewholder = new DataTestViewHolder(itemView);
        return datatestviewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Expense expense = listData.get(position);
        ((DataTestViewHolder)holder).setData(expense);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
