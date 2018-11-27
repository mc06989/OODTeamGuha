package edu.georgasouthern.oodteamguha;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public class SetupPagerAdapter extends PagerAdapter {
    private Context context;

    public SetupPagerAdapter(Context context, ){

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return false;
    }
}
