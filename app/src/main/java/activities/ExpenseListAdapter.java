package activities;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;

import java.util.List;

import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.R;

public class ExpenseListAdapter extends Adapter{
    List<TableDefinitions.Expense> listData;
    public ExpenseListAdapter(List<TableDefinitions.Expense> data){
        this.listData = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_tag, parent, false);
        ExpenseListViewHolder elvh = new ExpenseListViewHolder(itemView);
        return elvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TableDefinitions.Expense expense = listData.get(position);
        ((ExpenseListViewHolder)holder).setData(expense);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public TableDefinitions.Expense getItem(int position){
        return listData.get(position);
    }
}
