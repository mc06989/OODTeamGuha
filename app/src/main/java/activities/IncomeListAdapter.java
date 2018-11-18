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

public class IncomeListAdapter extends Adapter {
    List<TableDefinitions.Income> listData;
    public IncomeListAdapter(List<TableDefinitions.Income> data){
        this.listData = data;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.income_tag, parent, false);
        IncomeListViewHolder elvh = new IncomeListViewHolder(itemView);
        return elvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TableDefinitions.Income income = listData.get(position);
        ((IncomeListViewHolder)holder).setData(income);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public TableDefinitions.Income getItem(int position){
        return listData.get(position);
    }
}
