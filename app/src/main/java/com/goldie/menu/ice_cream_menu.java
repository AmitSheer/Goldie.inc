package com.goldie.menu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.goldie.R;

public class ice_cream_menu extends AppCompatActivity {

    RadioGroup strawberry;
    Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icereammuneu);
        Button back_btn = (Button) findViewById(R.id.back);
        back_btn.setOnClickListener(v -> openMenuPage());
        strawberry = findViewById(R.id.sGroup);
        apply = findViewById(R.id.apply);
        apply.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int s_checkedBtn = strawberry.getCheckedRadioButtonId();
                int v_checkedBtn = strawberry.getCheckedRadioButtonId();
                int p_checkedBtn = strawberry.getCheckedRadioButtonId();
                int c_checkedBtn = strawberry.getCheckedRadioButtonId();

                if (s_checkedBtn != -1) {//btn is checked
                    findRadioBtn(s_checkedBtn);

                }

                if (v_checkedBtn != -1) {//btn is checked
                    findRadioBtn(v_checkedBtn);

                }

                if (p_checkedBtn != -1) {//btn is checked
                    findRadioBtn(p_checkedBtn);

                }

                if (c_checkedBtn != -1) {//btn is checked
                    findRadioBtn(c_checkedBtn);

                }
            }
        });

    }

    @SuppressLint("NonConstantResourceId")
    private void findRadioBtn(int checkedBtn) {
        switch (checkedBtn) {
            case R.id.one_s:
                break;
            case R.id.two_s:
                break;
            case R.id.three_s:
                break;
        }
    }

    public void openMenuPage() {
        Intent intent = new Intent(this, menu.class);
        startActivity(intent);
    }
}
