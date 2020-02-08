package com.welezohealth.welezo;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.welezohealth.welezo.ui.home.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeSreen extends AppCompatActivity implements HomeFragment.OnscrollUpL {

    @BindView(R.id.moreid)
    CardView moreid;
    @BindView(R.id.searchUp)
    TextView searchUp;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_sreen);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.hamb);


        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void scrollup(String s) {
        AlphaAnimation animation2 = new AlphaAnimation(0.0f, 1.0f);
        animation2.setDuration(200);
        animation2.setFillAfter(true);
        moreid.startAnimation(animation2);
    }

    @Override
    public void scrolldownn(String s) {
        AlphaAnimation animation1 = new AlphaAnimation(1.0f, 0.0f);
        animation1.setDuration(200);
        animation1.setFillAfter(true);
        moreid.startAnimation(animation1);
    }

    @Override
    public void Searchscrollup(String s) {
        AlphaAnimation animation2 = new AlphaAnimation(0.0f, 1.0f);
        animation2.setDuration(200);
        animation2.setFillAfter(true);
        searchUp.startAnimation(animation2);

    }

    @Override
    public void Searchscrolldownn(String s) {
        AlphaAnimation animation2 = new AlphaAnimation(1.0f, 0.0f);
        animation2.setDuration(200);
        animation2.setFillAfter(true);
        searchUp.startAnimation(animation2);
    }
}
