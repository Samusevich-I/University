package com.a.tmdbclient.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.a.tmdbclient.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout mDrawer;
    private NavController mNavController;
    private MenuListViewAdapter mExpandableListAdapter;
    private ExpandableListView mExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (!mExpandableListAdapter.getGroup(groupPosition).hasChildren()) {
                    mNavController.navigate(mExpandableListAdapter.getGroup(groupPosition).getResId());
                    mDrawer.closeDrawers();
                }
                return false;
            }
        });

        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                mNavController.navigate(mExpandableListAdapter.getChild(groupPosition, childPosition).getResId());
                mDrawer.closeDrawers();
                return false;
            }
        });

    }

    private void init() {
        mDrawer = findViewById(R.id.drawer_layout);
        mExpandableListView = findViewById(R.id.activity_main_expandable_list_view);
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        NavigationView navigationView = findViewById(R.id.activity_main_nav_view);
        setSupportActionBar(toolbar);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_top_rated_movies,
                R.id.nav_now_playing_movies,
                R.id.nav_upcoming_movies,
                R.id.nav_popular_movies,
                R.id.nav_popular_shows,
                R.id.nav_upcoming_shows,
                R.id.nav_top_rated_shows,
                R.id.nav_now_playing_shows,
                R.id.nav_people)
                .setDrawerLayout(mDrawer)
                .build();
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, mNavController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, mNavController);

        mExpandableListAdapter = new MenuListViewAdapter(this);
        mExpandableListView.setAdapter(mExpandableListAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}
