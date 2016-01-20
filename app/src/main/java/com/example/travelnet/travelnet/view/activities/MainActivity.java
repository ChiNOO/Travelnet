package com.example.travelnet.travelnet.view.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.view.fragments.AttractionsFragment;
import com.example.travelnet.travelnet.view.fragments.FlightsFragment;
import com.example.travelnet.travelnet.view.fragments.HotelsFragment;
import com.example.travelnet.travelnet.view.fragments.HousesFragment;
import com.example.travelnet.travelnet.view.fragments.SettingsFragment;
import com.example.travelnet.travelnet.view.fragments.TravelsFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.dflabs.lib.mvp.BaseActivity;
import io.dflabs.lib.mvp.BasePresenter;

import static java.security.AccessController.getContext;

public class MainActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    @Bind(R.id.act_main_nav_view)
    NavigationView mNavigationView;
    @Bind(R.id.act_main_drawer_layout)
    DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHomeAsUpEnabled(false);
        setToolbarEnabled(false);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        selectItem(item.getItemId(), item.getTitle());
        return true;
    }

    private void selectItem(int itemId, CharSequence title) {
        Fragment fragment = null;
        switch (itemId) {
            case R.id.action_hotels:
                fragment = HotelsFragment.newInstance();
                break;
            case R.id.action_travels:
                fragment = TravelsFragment.newInstance();
                break;
            case R.id.action_attractions:
                fragment = AttractionsFragment.newInstance();
                break;
            case R.id.action_flights:
                fragment = FlightsFragment.newInstance();
                break;
            case R.id.action_houses:
                fragment = HousesFragment.newInstance();
                break;
            case R.id.action_settings:
                fragment = SettingsFragment.newInstance();
                break;
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setSubtitle(title);
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.act_main_content, fragment).commit();
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }
}
