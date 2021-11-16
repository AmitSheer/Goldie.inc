package com.goldie.menu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.goldie.R;

public class froyo_menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.froyomenu);
        Button back_btn = (Button) findViewById(R.id.back);
        back_btn.setOnClickListener(v -> openMenuPage());
    }

    public void openMenuPage(){
        Intent intent = new Intent(this,menu.class);
        startActivity(intent);
    }

}
