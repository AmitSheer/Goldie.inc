package com.goldie.menu;

import android.os.Bundle;
import android.view.View;

import com.goldie.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SellerAdviceFragment extends Fragment {

    public SellerAdviceFragment() {
        super(R.layout.fragment_seller_advice);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        setContentView(R.layout.fragment_crepe_menu);
//        Button back_btn = (Button) findViewById(R.id.back);
//        back_btn.setOnClickListener(v -> openMenuPage());
    }

//    public void openMenuPage(){
//        Intent intent = new Intent(this, MenuFragment.class);
//        startActivity(intent);
//    }
}
