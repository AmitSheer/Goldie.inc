package com.goldie.admin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.goldie.account.LoginViewNav;
import com.goldie.shop.ShopActivity;
import com.goldie.R;
import com.goldie.account.FirebaseAdapter;
import com.goldie.account.data.UserData;
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
        LoginViewNav.ChangeViewByUserType(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        navController = ((NavHostFragment) fragmentManager.findFragmentById(R.id.admin_nav_host_fragment)).getNavController();
        toolbar = findViewById(R.id.admin_toolbar);
        bottomAppBar = findViewById(R.id.admin_bottom_nav);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.ordersManagementFragment, R.id.storageManagementFragment).build();
        setSupportActionBar(toolbar);
        NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(bottomAppBar,navController);

        bottomAppBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(AdminMainActivity.this);

                        builder.setTitle("Sure you want to logout?");
                        builder.setCancelable(true);
                        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int id) {
                                Toast.makeText(getApplicationContext(), "Admin Logged out", Toast.LENGTH_SHORT).show();
                                // LogOut
                                FirebaseAdapter.fAuth.signOut();
                                UserData.empty();
                                startActivity(new Intent(getApplicationContext(), AdminMainActivity.class));
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
