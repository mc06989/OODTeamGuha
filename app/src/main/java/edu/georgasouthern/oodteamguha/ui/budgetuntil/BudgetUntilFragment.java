package edu.georgasouthern.oodteamguha.ui.budgetuntil;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.georgasouthern.oodteamguha.R;

public class BudgetUntilFragment extends Fragment {

    private BudgetUntilViewModel mViewModel;

    public static BudgetUntilFragment newInstance() {
        return new BudgetUntilFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.budget_until_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BudgetUntilViewModel.class);
        // TODO: Use the ViewModel
    }

}
