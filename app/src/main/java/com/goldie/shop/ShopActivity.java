package com.goldie.shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.goldie.R;
import com.goldie.account.FirebaseAdapter;
import com.goldie.account.LoginViewNav;
import com.goldie.account.data.UserData;
import com.goldie.shop.shoppingcart.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.HashMap;
import java.util.List;

public class ShopActivity extends AppCompatActivity {
    public static int order_id=0;
    private NavController navController;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    //Order order2;
    public static LinkedHashMap<String,Product> order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        order=new LinkedHashMap<>();
        order_id++;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        FragmentManager fragmentManager = getSupportFragmentManager();
        navController = ((NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment)).getNavController();
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        setSupportActionBar(toolbar);
        NavigationUI.setupWithNavController(toolbar,navController);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
        LoginViewNav.ChangeViewByUserType(this);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.logout:
                        Toast.makeText(getApplicationContext(), "User Logged out", Toast.LENGTH_SHORT).show();
                        // LogOut
                        FirebaseAdapter.fAuth.signOut();
                        UserData.empty();
                        startActivity(new Intent(getApplicationContext(), ShopActivity.class));
                        finish();
                        break;
                    default:
                        return NavigationUI.onNavDestinationSelected(item,navController);
                }

                return true;
            }
        });
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