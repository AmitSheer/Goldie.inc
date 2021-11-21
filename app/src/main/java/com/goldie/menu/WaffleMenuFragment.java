package com.goldie.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.goldie.R;

public class WaffleMenuFragment extends Fragment {

    ImageButton classic;

    public WaffleMenuFragment() {
        super(R.layout.fragment_waffle_menu);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        classic = view.findViewById(R.id.waffleBtn);

        classic.setOnClickListener(new View.OnClickListener() {
            boolean checkActionOpen = false;
            @Override
            public void onClick(View view) {
                if (!checkActionOpen) {
                    checkActionOpen = true;
                    classic.setSelected(true);
                }
                else {
                    checkActionOpen = false;
                    classic.setSelected(false);
                }
            }
        });

//        setContentView(R.layout.fragment_waffle_menu);
//        Button back_btn = (Button) findViewById(R.id.back);
//        back_btn.setOnClickListener(v -> openMenuPage());


//    public void openMenuPage(){
//        Intent intent = new Intent(this, MenuFragment.class);
//        startActivity(intent);
//    }

    }
}