package com.goldie.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.goldie.R;

public class FroyoMenuFragment extends Fragment {

    public FroyoMenuFragment() {
        super(R.layout.fragment_froyo_menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        setContentView(R.layout.fragment_froyo_menu);
//        Button back_btn = (Button) findViewById(R.id.back);
//        back_btn.setOnClickListener(v -> openMenuPage());
    }

//    public void openMenuPage(){
//        Intent intent = new Intent(this, MenuFragment.class);
//        startActivity(intent);
//    }

}
