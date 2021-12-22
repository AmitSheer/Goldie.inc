package com.goldie.admin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.goldie.R;
import com.goldie.account.FirebaseAdapter;
import com.goldie.account.LoginViewNav;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class DeliveriesAdminMainActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginViewNav.ChangeViewByUserType(this);
        setContentView(R.layout.activity_delivery);
        FragmentManager fragmentManager = getSupportFragmentManager();
        navController = ((NavHostFragment) fragmentManager.findFragmentById(R.id.delivery_host_fragment)).getNavController();
        Toolbar toolbar = findViewById(R.id.delivery_top_nav);
        BottomNavigationView bottomAppBar = findViewById(R.id.delivery_nav);
        setSupportActionBar(toolbar);
        NavigationUI.setupWithNavController(toolbar, navController);
        NavigationUI.setupWithNavController(bottomAppBar, navController);
        bottomAppBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DeliveriesAdminMainActivity.this);
                builder.setTitle("Sure you want to logout?");
                builder.setCancelable(true);
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Toast.makeText(getApplicationContext(), "Delivery Logged out", Toast.LENGTH_SHORT).show();
                        // LogOut
                        FirebaseAdapter.fAuth.signOut();
                        LoginViewNav.ChangeViewByUserType(DeliveriesAdminMainActivity.this);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return true;
            }
        });
    }
}
