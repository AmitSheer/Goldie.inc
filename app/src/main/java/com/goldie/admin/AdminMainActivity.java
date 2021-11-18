package com.goldie.admin;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.goldie.R;
import com.goldie.account.LoginFragment;
import com.goldie.account.LoginFragmentDirections;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import static com.google.android.gms.common.util.CollectionUtils.setOf;

public class AdminMainActivity extends AppCompatActivity {
    private NavController navController;
    private Toolbar toolbar;
    private BottomNavigationView bottomAppBar;

    public AdminMainActivity() {
        super(R.layout.activity_admin_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        navController = ((NavHostFragment) fragmentManager.findFragmentById(R.id.admin_nav_host_fragment)).getNavController();
        toolbar = findViewById(R.id.admin_toolbar);
        bottomAppBar = findViewById(R.id.admin_bottom_nav);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.ordersManagementFragment, R.id.storageManagementFragment).build();
        setSupportActionBar(toolbar);
        NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(bottomAppBar,navController);
//        LoginFragmentDirections.actionGlobalLoginFragment();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item,navController) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp()||super.onSupportNavigateUp();
    }
}
