package com.goldie.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.goldie.R;


public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ImageButton ice_btn = findViewById(R.id.icecream);
        ice_btn.setOnClickListener(v -> openIceCreamPage());
        ImageButton waffle_btn = findViewById(R.id.waffle);
        waffle_btn.setOnClickListener(v -> openWafflePage());
        ImageButton crepe_btn = findViewById(R.id.crepes);
        crepe_btn.setOnClickListener(v -> openCrepePage());
        ImageButton froyo_btn = findViewById(R.id.froyo);
        froyo_btn.setOnClickListener(v -> openFroyoPage());
    }
    public void openIceCreamPage(){
        Intent intent = new Intent(this,ice_cream_menu.class);
        startActivity(intent);
    }

    public void openWafflePage(){
        Intent intent = new Intent(this, waffle_menu.class);
        startActivity(intent);
    }
    public void openCrepePage(){
        Intent intent = new Intent(this, crepe_menu.class);
        startActivity(intent);
    }

    public void openFroyoPage(){
        Intent intent = new Intent(this, froyo_menu.class);
        startActivity(intent);
    }

}