package activities;

import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import database.TableDefinitions;
import edu.georgasouthern.oodteamguha.R;
import fragments.AddExpenseDialogFragment;
import fragments.DataInputFragment;
import fragments.InflationGraphFragment;
import fragments.SettingsFragment;


public class NavPane extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DataInputFragment.OnFragmentInteractionListener,AddExpenseDialogFragment.OnDialogCloseListener {

    private DrawerLayout drawerLayout;

    private void configureToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //actionbar.setHomeAsUpIndicator(R.drawable.);
        //actionbar.setDisplayHomeAsUpEnabled(true);
    }

    private void configureNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_pane);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        configureToolbar();
        configureNavigationDrawer();
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Fragment fragment = DataInputFragment.newInstance(0);
        //getFragmentManager().beginTransaction().replace(R.id.background, fragment,fragment.getClass().getName()).addToBackStack(null).commit();
        swapFragments(fragment);
        updateDrawer(fragment);

    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_pane, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        switch (id) {
            case R.id.action_settings:
                fragment = SettingsFragment.newInstance("", "");
                break;
            case R.id.test_activities:
                fragment = new InflationGraphFragment();
                break;
            case R.id.data_input:
                fragment = new DataInputFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            swapFragments(fragment);
            updateDrawer(fragment);
        }


        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void swapFragments(Fragment fragment) {
        boolean doesPop = getSupportFragmentManager().popBackStackImmediate(fragment.getClass().getName(), 0);
        System.out.println("Fragment class: " + fragment.getClass().getName());
        if (!(doesPop) && getSupportFragmentManager().findFragmentByTag(fragment.getClass().getName()) == null) {
            System.out.println("Adding nonexistent fragment " + getSupportFragmentManager().getBackStackEntryCount());
            getSupportFragmentManager().beginTransaction().replace(R.id.background, fragment, fragment.getClass().getName()).addToBackStack(fragment.getClass().getName()).commit();
        } else {
            System.err.println("Found fragment");
        }
    }

    public void updateDrawer(Fragment fragment) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            if (fragment instanceof DataInputFragment) {
                actionBar.setTitle("Input your data");
            } else if (fragment instanceof InflationGraphFragment) {
                actionBar.setTitle("Inflation Graph");

            } else {
                actionBar.setTitle("Balance");
            }
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void OnDialogClose(TableDefinitions.Expense e) {
        DataInputFragment fm = (DataInputFragment) getSupportFragmentManager().findFragmentByTag("data_input");
        fm.OnDialogClose(e);
    }
}
