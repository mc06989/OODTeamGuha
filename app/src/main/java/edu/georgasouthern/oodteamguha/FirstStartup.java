package edu.georgasouthern.oodteamguha;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import database.TableDefinitions;
import fragments.AddExpenseDialogFragment;
import fragments.DataInputFragment;
import fragments.SettingsFragment;

public class FirstStartup extends AppCompatActivity implements DataInputFragment.OnFragmentInteractionListener, AddExpenseDialogFragment.OnDialogCloseListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_startup);

//        List<Fragment> fragments = new ArrayList<Fragment>();
//        fragments.add(new DataInputFragment());
//
//        FragmentPagerAdapter fpa = new FragmentPagerAdapter(getSupportFragmentManager()) {
//
//            @Override
//            public Fragment getItem(int i) {
//                return null;
//            }
//
//            @Override
//            public int getCount() {
//                return getSupportFragmentManager().getFragments().size();
//            }
//        };
//
//        fpa.notifyDataSetChanged();
//
//        ViewPager pager = findViewById(R.id.pager);
//        pager.setAdapter(fpa);
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
//        tabLayout.setupWithViewPager(pager, true);
//
//
//        getSupportFragmentManager().beginTransaction().add(new WelcomeFragment(),DataInputFragment.class.getName()).addToBackStack(null).commit();



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void OnDialogClose(TableDefinitions.Expense e) {

    }


    public class ViewerPageAdapter extends PagerAdapter{

        Context vContext;
        //ArrayList

        public ViewerPageAdapter(Context _context){
            super();

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


//    public static class WelcomeFragment extends Fragment{
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            // Inflate the layout for this fragment
//            return inflater.inflate(R.layout.welcome, container, false);
//        }
//    }
}
