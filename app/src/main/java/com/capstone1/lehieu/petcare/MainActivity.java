package com.capstone1.lehieu.petcare;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottom_nav;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        init();
        setupNavigation();
//        setNavigationVisibility(true);
    }

    //METHOD
    private void init() {
        bottom_nav = findViewById(R.id.bottom_nav);
    }
    private void setupNavigation() {
        navController = Navigation.findNavController(MainActivity.this, R.id.my_nav_host_fragment);
        NavigationUI.setupWithNavController(bottom_nav, navController);
//        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController);
    }
    public void setNavigationVisibility(boolean visible) {
        if (visible) {
            bottom_nav.setVisibility(View.VISIBLE);
        } else {
            bottom_nav.setVisibility(View.GONE);
        }
//
//        if (bottom_nav.isShown() && visible) {
//            bottom_nav.setVisibility(View.GONE);
//        } else if (!bottom_nav.isShown() && !visible) {
//            bottom_nav.setVisibility(View.VISIBLE);
//        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp();
    }

}
