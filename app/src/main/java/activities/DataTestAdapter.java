package activities;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import database.TableDefinitions.Expense;
import edu.georgasouthern.oodteamguha.R;

public class DataTestAdapter extends Adapter {

    final List<Expense> listData;

    public DataTestAdapter(List<Expense> data) {
        this.listData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_tag, parent, false);
        return new DataTestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Expense expense = listData.get(position);
        ((DataTestViewHolder) holder).setData(expense);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public Expense getItem(int position) {
        return listData.get(position);
    }
}
