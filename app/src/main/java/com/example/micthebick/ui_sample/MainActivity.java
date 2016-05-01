package com.example.micthebick.ui_sample;

import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawer;
    private Toolbar mtoolbar;
    private ActionBarDrawerToggle   drawerToggle;
    private int mSelectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setToolbar();
        initView();

        drawerToggle=new ActionBarDrawerToggle(this,mDrawer, mtoolbar,R.string.drawer_open,R.string.drawer_close);
        mDrawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        mSelectedId=savedInstanceState == null ? R.id.navigation_sub_item_1: savedInstanceState.getInt("SELECTED_ID");
        itemSelection(mSelectedId);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                item.setChecked(true);

                return false;
            }
        });
    }

    private void setToolbar()   {

        mtoolbar    =   (Toolbar)findViewById(R.id.toolbar);

        if (mtoolbar != null) {
            setSupportActionBar(mtoolbar);
        }
    }

    private void initView(){

        mNavigationView =   (NavigationView)findViewById(R.id.navigation_view);
        mDrawer =   (DrawerLayout)findViewById(R.id.drawerLayout);

    }

    private void itemSelection(int mSelectedId){

        switch (mSelectedId){

            case R.id.nav_home:
                mDrawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_about:
                mDrawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_settings:
                mDrawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.navigation_sub_item_1:
                mDrawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.navigation_sub_item_2:
                mDrawer.closeDrawer(GravityCompat.START);
                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }



}
