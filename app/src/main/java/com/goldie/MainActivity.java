package com.goldie;

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

import com.goldie.account.FirebaseAdapter;
import com.goldie.account.data.UserData;
import com.goldie.admin.AdminMainActivity;
import com.goldie.shoppingcart.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static int order_id=0;
    private NavController navController;
    private Toolbar toolbar;
    public static HashMap<Integer,Product> order;
    //Order order2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        order=new HashMap<>();
        order_id++;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        navController = ((NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment)).getNavController();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationUI.setupWithNavController(toolbar,navController);
        NavigationUI.setupWithNavController((BottomNavigationView) findViewById(R.id.bottom_nav),navController);
        try {
            FirebaseAdapter.UpdateUserData().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        if (UserData.IsAdmin) {
                            Intent intent = new Intent(getBaseContext(), AdminMainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            });
        }catch(Exception e){
            navController.navigate(R.id.loginFragment);
        }
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