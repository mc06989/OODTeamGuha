package activities;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.R;

public class ExpenseListAdapter extends Adapter {
    final List<TableDefinitions.Expense> listData;

    public ExpenseListAdapter(List<TableDefinitions.Expense> data) {
        this.listData = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_tag, parent, false);
        return new ExpenseListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TableDefinitions.Expense expense = listData.get(position);
        ((ExpenseListViewHolder) holder).setData(expense);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public TableDefinitions.Expense getItem(int position) {
        return listData.get(position);
    }
}
