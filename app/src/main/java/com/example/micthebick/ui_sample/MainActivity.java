package com.example.micthebick.ui_sample;

import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.micthebick.fragment.FirstFragment;
import com.example.micthebick.fragment.ThreeFragment;
import com.example.micthebick.fragment.TwoFragment;


public class MainActivity extends ActionBarActivity {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawer;
    private Toolbar mtoolbar;
    private ActionBarDrawerToggle   drawerToggle;
    private int mSelectedId;

    private CharSequence    mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setToolbar();
        initView();

        getSupportFragmentManager().beginTransaction().add(R.id.lookup_contents, new FirstFragment().newInstance()).commit();

        drawerToggle=new ActionBarDrawerToggle(this,mDrawer, mtoolbar,R.string.drawer_open,R.string.drawer_close);
        mDrawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        mSelectedId=savedInstanceState == null ? R.id.navigation_sub_item_1: savedInstanceState.getInt("SELECTED_ID");
        itemSelection(mSelectedId);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                itemSelection(item.getItemId());
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

        FragmentManager fragmentManager =   getSupportFragmentManager();

        switch (mSelectedId){

            case R.id.nav_home:
                Toast.makeText(getApplication(), "Home Button pushed",Toast.LENGTH_LONG).show();
                mDrawer.closeDrawer(GravityCompat.START);
                fragmentManager.beginTransaction().replace(R.id.lookup_contents, FirstFragment.newInstance()).commit();
                onSectionAttached(mSelectedId);
                mtoolbar.setTitle(mTitle);
                break;

            case R.id.nav_about:
                Toast.makeText(getApplication(), "ABOUT Button pushed",Toast.LENGTH_LONG).show();
                mDrawer.closeDrawer(GravityCompat.START);
                fragmentManager.beginTransaction().replace(R.id.lookup_contents, TwoFragment.newInstance()).commit();
                onSectionAttached(mSelectedId);
                mtoolbar.setTitle(mTitle);
                break;

            case R.id.nav_settings:
                Toast.makeText(getApplication(), "SETTING Button pushed",Toast.LENGTH_LONG).show();
                mDrawer.closeDrawer(GravityCompat.START);
                fragmentManager.beginTransaction().replace(R.id.lookup_contents, ThreeFragment.newInstance()).commit();
                onSectionAttached(mSelectedId);
                mtoolbar.setTitle(mTitle);
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

    public void onSectionAttached(int number) {

        System.out.println(mTitle);

        switch (number){

            case R.id.nav_home:
                mTitle  =   getString(R.string.nav_home);
                break;

            case R.id.nav_about:
                mTitle  =   getString(R.string.nav_about);
                break;

            case R.id.nav_settings:
                mTitle  =   getString(R.string.nav_settings);
                break;

            default:
                break;
        }
    }
}
