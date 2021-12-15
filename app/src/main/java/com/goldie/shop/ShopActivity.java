package com.goldie.shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.goldie.R;
import com.goldie.account.FirebaseAdapter;
import com.goldie.account.LoginViewNav;
import com.goldie.account.data.UserData;
import com.goldie.shop.shoppingcart.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ShopActivity extends AppCompatActivity {
    public static int order_id=0;
    private NavController navController;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton callerFab;
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
        callerFab = findViewById(R.id.callerFab);
        callerFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:Demo Number");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                try {
                    startActivity(callIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(ShopActivity.this);

                        builder.setTitle("Sure you want to logout?");
                        builder.setCancelable(true);
                        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int id) {
                                Toast.makeText(getApplicationContext(), "User Logged out", Toast.LENGTH_SHORT).show();
                                FirebaseAdapter.fAuth.signOut();
                                UserData.empty();
                                startActivity(new Intent(getApplicationContext(), ShopActivity.class));
                                finish();
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
                        // LogOut

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