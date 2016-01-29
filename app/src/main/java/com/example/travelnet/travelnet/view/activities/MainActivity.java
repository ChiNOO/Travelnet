package com.example.travelnet.travelnet.view.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.travelnet.travelnet.R;
import com.example.travelnet.travelnet.view.fragments.AttractionsFragment;
import com.example.travelnet.travelnet.view.fragments.FlightsFragment;
import com.example.travelnet.travelnet.view.fragments.HotelsFragment;
import com.example.travelnet.travelnet.view.fragments.HousesFragment;
import com.example.travelnet.travelnet.view.fragments.SettingsFragment;
import com.example.travelnet.travelnet.view.fragments.TravelsFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    @Bind(R.id.toolbar)
    android.support.v7.widget.Toolbar mToolbar;
    @Bind(R.id.act_main_nav_view)
    NavigationView mNavigationView;
    @Bind(R.id.act_main_drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.toolbar_container)
    FrameLayout mToolbarContainer;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHomeAsUpEnabled(false);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mNavigationView.setNavigationItemSelectedListener(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerToggle.setDrawerIndicatorEnabled(false);
        mDrawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

    }

    @OnClick(R.id.toolbar)
    public void onClickToolbar(){
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

    public FrameLayout getToolbarContainer() {
        return mToolbarContainer;
    }
}