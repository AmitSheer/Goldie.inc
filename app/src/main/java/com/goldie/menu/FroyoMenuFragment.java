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
import com.goldie.account.FirebaseAdapter;
import com.goldie.account.data.UserData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FroyoMenuFragment extends Fragment {

    FroyoObject froyoObject;
    Button apply;
    ImageButton small, medium, large, kiwi, peach, mango, blueberry, strawberry, blackberry;

    public FroyoMenuFragment() {
        super(R.layout.fragment_froyo_menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        froyoObject = new FroyoObject();
        small = view.findViewById(R.id.small);
        medium = view.findViewById(R.id.medium);
        large = view.findViewById(R.id.large);
        kiwi = view.findViewById(R.id.kiviImage);
        peach = view.findViewById(R.id.peachImage);
        mango = view.findViewById(R.id.magoImage);
        blueberry = view.findViewById(R.id.blueberryImage);
        strawberry = view.findViewById(R.id.strawberryImage);
        blackberry = view.findViewById(R.id.blackberryImage);
        apply = view.findViewById(R.id.applyInFroyo);


        small.setOnClickListener(view1 -> {
            if (!small.isSelected() && !medium.isSelected() && !large.isSelected()) {
                small.setSelected(true);
                froyoObject.cupSize[0].setAmount(1);
            }

            else if (!small.isSelected() && medium.isSelected() ) {
                medium.setSelected(false);
                froyoObject.cupSize[1].setAmount(0);
                small.setSelected(true);
                froyoObject.cupSize[0].setAmount(1);
            }

            else if (!small.isSelected() && large.isSelected() ) {
                large.setSelected(false);
                froyoObject.cupSize[2].setAmount(0);
                small.setSelected(true);
                froyoObject.cupSize[0].setAmount(1);
            }

            else {
                small.setSelected(false);
                froyoObject.cupSize[0].setAmount(0);
            }
        });

        medium.setOnClickListener(view1 -> {
            if (!medium.isSelected() && !small.isSelected() && !large.isSelected()) {
                medium.setSelected(true);
                froyoObject.cupSize[1].setAmount(1);
            }


            else if (!medium.isSelected() && small.isSelected() ) {
                small.setSelected(false);
                froyoObject.cupSize[0].setAmount(0);
                medium.setSelected(true);
                froyoObject.cupSize[1].setAmount(1);
            }

            else if (!medium.isSelected() && large.isSelected() ) {
                large.setSelected(false);
                froyoObject.cupSize[2].setAmount(0);
                medium.setSelected(true);
                froyoObject.cupSize[1].setAmount(1);
            }

            else {
                medium.setSelected(false);
                froyoObject.cupSize[1].setAmount(0);
            }
        });

        large.setOnClickListener(view1 -> {
            if (!medium.isSelected() && !small.isSelected() && !large.isSelected()) {
                large.setSelected(true);
                froyoObject.cupSize[2].setAmount(1);
            }


            else if (!large.isSelected() && small.isSelected() ) {
                small.setSelected(false);
                froyoObject.cupSize[0].setAmount(0);
                large.setSelected(true);
                froyoObject.cupSize[2].setAmount(1);
            }

            else if (!large.isSelected() && medium.isSelected() ) {
                medium.setSelected(false);
                froyoObject.cupSize[1].setAmount(0);
                large.setSelected(true);
                froyoObject.cupSize[2].setAmount(1);
            }

            else {
                large.setSelected(false);
                froyoObject.cupSize[2].setAmount(0);
            }
        });

        kiwi.setOnClickListener(view13 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                kiwi.setSelected(true);
                froyoObject.flavor[0].setAmount(1);
            }
            else if(!kiwi.isSelected()&& peach.isSelected()){
                kiwi.setSelected(true);
                froyoObject.flavor[0].setAmount(1);
                peach.setSelected(false);
                froyoObject.flavor[1].setAmount(0);
            }
            else if(!kiwi.isSelected()&& mango.isSelected()){
                kiwi.setSelected(true);
                froyoObject.flavor[0].setAmount(1);
                mango.setSelected(false);
                froyoObject.flavor[2].setAmount(0);
            }
            else if(!kiwi.isSelected()&& blueberry.isSelected()){
                kiwi.setSelected(true);
                froyoObject.flavor[0].setAmount(1);
                blueberry.setSelected(false);
                froyoObject.flavor[3].setAmount(0);
            }
            else if(!kiwi.isSelected()&& strawberry.isSelected()){
                kiwi.setSelected(true);
                froyoObject.flavor[0].setAmount(1);
                strawberry.setSelected(false);
                froyoObject.flavor[4].setAmount(0);
            }
            else if(!kiwi.isSelected()&& blackberry.isSelected()){
                kiwi.setSelected(true);
                froyoObject.flavor[0].setAmount(1);
                blackberry.setSelected(false);
                froyoObject.flavor[5].setAmount(0);
            }
            else {
                kiwi.setSelected(false);
                froyoObject.flavor[0].setAmount(0);
            }
        });

        peach.setOnClickListener(view12 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                    &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                peach.setSelected(true);
                froyoObject.flavor[1].setAmount(1);
            }
            else if(!peach.isSelected()&& kiwi.isSelected()){
                peach.setSelected(true);
                froyoObject.flavor[1].setAmount(1);
                kiwi.setSelected(false);
                froyoObject.flavor[0].setAmount(0);
            }
            else if(!peach.isSelected()&& mango.isSelected()){
                peach.setSelected(true);
                froyoObject.flavor[1].setAmount(1);
                mango.setSelected(false);
                froyoObject.flavor[2].setAmount(0);
            }
            else if(!peach.isSelected()&& blueberry.isSelected()){
                peach.setSelected(true);
                froyoObject.flavor[1].setAmount(1);
                blueberry.setSelected(false);
                froyoObject.flavor[3].setAmount(0);
            }
            else if(!peach.isSelected()&& strawberry.isSelected()){
                peach.setSelected(true);
                froyoObject.flavor[1].setAmount(1);
                strawberry.setSelected(false);
                froyoObject.flavor[4].setAmount(0);
            }
            else if(!peach.isSelected()&& blackberry.isSelected()){
                peach.setSelected(true);
                froyoObject.flavor[1].setAmount(1);
                blackberry.setSelected(false);
                froyoObject.flavor[5].setAmount(0);
            }
            else {
                peach.setSelected(false);
                froyoObject.flavor[1].setAmount(0);
            }
        });

        mango.setOnClickListener(view13 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                    &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                mango.setSelected(true);
                froyoObject.flavor[2].setAmount(1);
            }
            else if(!mango.isSelected()&& kiwi.isSelected()){
                mango.setSelected(true);
                froyoObject.flavor[2].setAmount(1);
                kiwi.setSelected(false);
                froyoObject.flavor[0].setAmount(0);
            }
            else if(!mango.isSelected()&& peach.isSelected()){
                mango.setSelected(true);
                froyoObject.flavor[2].setAmount(1);
                peach.setSelected(false);
                froyoObject.flavor[1].setAmount(0);
            }
            else if(!mango.isSelected()&& blueberry.isSelected()){
                mango.setSelected(true);
                froyoObject.flavor[2].setAmount(1);
                blueberry.setSelected(false);
                froyoObject.flavor[3].setAmount(0);
            }
            else if(!mango.isSelected()&& strawberry.isSelected()){
                mango.setSelected(true);
                froyoObject.flavor[2].setAmount(1);
                strawberry.setSelected(false);
                froyoObject.flavor[4].setAmount(0);
            }
            else if(!mango.isSelected()&& blackberry.isSelected()){
                mango.setSelected(true);
                froyoObject.flavor[2].setAmount(1);
                blackberry.setSelected(false);
                froyoObject.flavor[5].setAmount(0);
            }
            else {
                mango.setSelected(false);
                froyoObject.flavor[2].setAmount(0);
            }
        });

        blueberry.setOnClickListener(view13 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                    &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                blueberry.setSelected(true);
                froyoObject.flavor[3].setAmount(1);
            }
            else if(!blueberry.isSelected()&& kiwi.isSelected()){
                blueberry.setSelected(true);
                froyoObject.flavor[3].setAmount(1);
                kiwi.setSelected(false);
                froyoObject.flavor[0].setAmount(0);
            }
            else if(!blueberry.isSelected()&& peach.isSelected()){
                blueberry.setSelected(true);
                froyoObject.flavor[3].setAmount(1);
                peach.setSelected(false);
                froyoObject.flavor[1].setAmount(0);
            }
            else if(!blueberry.isSelected()&& mango.isSelected()){
                blueberry.setSelected(true);
                froyoObject.flavor[3].setAmount(1);
                mango.setSelected(false);
                froyoObject.flavor[2].setAmount(0);
            }
            else if(!blueberry.isSelected()&& strawberry.isSelected()){
                blueberry.setSelected(true);
                froyoObject.flavor[3].setAmount(1);
                strawberry.setSelected(false);
                froyoObject.flavor[4].setAmount(0);
            }
            else if(!blueberry.isSelected()&& blackberry.isSelected()){
                blueberry.setSelected(true);
                froyoObject.flavor[3].setAmount(1);
                blackberry.setSelected(false);
                froyoObject.flavor[5].setAmount(0);
            }
            else {
                blueberry.setSelected(false);
                froyoObject.flavor[3].setAmount(0);
            }
        });

        strawberry.setOnClickListener(view13 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                    &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                strawberry.setSelected(true);
                froyoObject.flavor[4].setAmount(1);
            }
            else if(!strawberry.isSelected()&& kiwi.isSelected()){
                strawberry.setSelected(true);
                froyoObject.flavor[4].setAmount(1);
                kiwi.setSelected(false);
                froyoObject.flavor[0].setAmount(0);
            }
            else if(!strawberry.isSelected()&& peach.isSelected()){
                strawberry.setSelected(true);
                froyoObject.flavor[4].setAmount(1);
                peach.setSelected(false);
                froyoObject.flavor[1].setAmount(0);
            }
            else if(!strawberry.isSelected()&& mango.isSelected()){
                strawberry.setSelected(true);
                froyoObject.flavor[4].setAmount(1);
                mango.setSelected(false);
                froyoObject.flavor[2].setAmount(0);
            }
            else if(!strawberry.isSelected()&& blueberry.isSelected()){
                strawberry.setSelected(true);
                froyoObject.flavor[4].setAmount(1);
                blueberry.setSelected(false);
                froyoObject.flavor[3].setAmount(0);
            }
            else if(!strawberry.isSelected()&& blackberry.isSelected()){
                strawberry.setSelected(true);
                froyoObject.flavor[4].setAmount(1);
                blackberry.setSelected(false);
                froyoObject.flavor[5].setAmount(0);
            }
            else {
                strawberry.setSelected(false);
                froyoObject.flavor[4].setAmount(0);
            }
        });

        blackberry.setOnClickListener(view13 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                    &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                blackberry.setSelected(true);
                froyoObject.flavor[5].setAmount(1);
            }
            else if(!blackberry.isSelected()&& kiwi.isSelected()){
                blackberry.setSelected(true);
                froyoObject.flavor[5].setAmount(1);
                kiwi.setSelected(false);
                froyoObject.flavor[0].setAmount(0);
            }
            else if(!blackberry.isSelected()&& peach.isSelected()){
                blackberry.setSelected(true);
                froyoObject.flavor[5].setAmount(1);
                peach.setSelected(false);
                froyoObject.flavor[1].setAmount(0);
            }
            else if(!blackberry.isSelected()&& mango.isSelected()){
                blackberry.setSelected(true);
                froyoObject.flavor[5].setAmount(1);
                mango.setSelected(false);
                froyoObject.flavor[2].setAmount(0);
            }
            else if(!blackberry.isSelected()&& blueberry.isSelected()){
                blackberry.setSelected(true);
                froyoObject.flavor[5].setAmount(1);
                blueberry.setSelected(false);
                froyoObject.flavor[3].setAmount(0);
            }
            else if(!blackberry.isSelected()&& strawberry.isSelected()){
                blackberry.setSelected(true);
                froyoObject.flavor[5].setAmount(1);
                strawberry.setSelected(false);
                froyoObject.flavor[4].setAmount(0);
            }
            else {
                blackberry.setSelected(false);
                froyoObject.flavor[5].setAmount(0);
            }
        });

        apply.setOnClickListener(v -> {
            if (large.isSelected()||medium.isSelected()||small.isSelected()){
                DatabaseReference refNewOrder = FirebaseDatabase.getInstance().getReference().child("Orders").push();
                refNewOrder.setValue(froyoObject);
            }
        });
    }
}