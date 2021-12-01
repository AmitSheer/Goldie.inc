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
                froyoObject.setSmall(true);
            }

            else if (!small.isSelected() && medium.isSelected() ) {
                medium.setSelected(false);
                froyoObject.setMedium(false);
                small.setSelected(true);
                froyoObject.setSmall(true);
            }

            else if (!small.isSelected() && large.isSelected() ) {
                large.setSelected(false);
                froyoObject.setLarge(false);
                small.setSelected(true);
                froyoObject.setSmall(true);
            }

            else {
                small.setSelected(false);
                froyoObject.setSmall(false);
            }
        });

        medium.setOnClickListener(view1 -> {
            if (!medium.isSelected() && !small.isSelected() && !large.isSelected()) {
                medium.setSelected(true);
                froyoObject.setMedium(true);
            }


            else if (!medium.isSelected() && small.isSelected() ) {
                small.setSelected(false);
                froyoObject.setSmall(false);
                medium.setSelected(true);
                froyoObject.setMedium(true);
            }

            else if (!medium.isSelected() && large.isSelected() ) {
                large.setSelected(false);
                froyoObject.setLarge(false);
                medium.setSelected(true);
                froyoObject.setMedium(true);
            }

            else {
                medium.setSelected(false);
                froyoObject.setMedium(false);
            }
        });

        large.setOnClickListener(view1 -> {
            if (!medium.isSelected() && !small.isSelected() && !large.isSelected()) {
                large.setSelected(true);
                froyoObject.setLarge(true);
            }


            else if (!large.isSelected() && small.isSelected() ) {
                small.setSelected(false);
                froyoObject.setSmall(false);
                large.setSelected(true);
                froyoObject.setLarge(true);
            }

            else if (!large.isSelected() && medium.isSelected() ) {
                medium.setSelected(false);
                froyoObject.setMedium(false);
                large.setSelected(true);
                froyoObject.setLarge(true);
            }

            else {
                large.setSelected(false);
                froyoObject.setLarge(false);
            }
        });

        kiwi.setOnClickListener(view13 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                kiwi.setSelected(true);
                froyoObject.setKiwi(true);
            }
            else if(!kiwi.isSelected()&& peach.isSelected()){
                kiwi.setSelected(true);
                froyoObject.setKiwi(true);
                peach.setSelected(false);
                froyoObject.setPeach(false);
            }
            else if(!kiwi.isSelected()&& mango.isSelected()){
                kiwi.setSelected(true);
                froyoObject.setKiwi(true);
                mango.setSelected(false);
                froyoObject.setMango(false);
            }
            else if(!kiwi.isSelected()&& blueberry.isSelected()){
                kiwi.setSelected(true);
                froyoObject.setKiwi(true);
                blueberry.setSelected(false);
                froyoObject.setBlueberry(false);
            }
            else if(!kiwi.isSelected()&& blackberry.isSelected()){
                kiwi.setSelected(true);
                froyoObject.setKiwi(true);
                blackberry.setSelected(false);
                froyoObject.setBlackberry(false);
            }
            else if(!kiwi.isSelected()&& strawberry.isSelected()){
                kiwi.setSelected(true);
                froyoObject.setKiwi(true);
                strawberry.setSelected(false);
                froyoObject.setStrawberry(false);
            }
            else {
                kiwi.setSelected(false);
                froyoObject.setKiwi(false);
            }
        });

        peach.setOnClickListener(view12 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                    &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                peach.setSelected(true);
                froyoObject.setPeach(true);
            }
            else if(!peach.isSelected()&& kiwi.isSelected()){
                peach.setSelected(true);
                froyoObject.setPeach(true);
                kiwi.setSelected(false);
                froyoObject.setKiwi(false);
            }
            else if(!peach.isSelected()&& mango.isSelected()){
                peach.setSelected(true);
                froyoObject.setPeach(true);
                mango.setSelected(false);
                froyoObject.setMango(false);
            }
            else if(!peach.isSelected()&& blueberry.isSelected()){
                peach.setSelected(true);
                froyoObject.setPeach(true);
                blueberry.setSelected(false);
                froyoObject.setBlueberry(false);
            }
            else if(!peach.isSelected()&& blackberry.isSelected()){
                peach.setSelected(true);
                froyoObject.setPeach(true);
                blackberry.setSelected(false);
                froyoObject.setBlackberry(false);
            }
            else if(!peach.isSelected()&& strawberry.isSelected()){
                peach.setSelected(true);
                froyoObject.setPeach(true);
                strawberry.setSelected(false);
                froyoObject.setStrawberry(false);
            }
            else {
                peach.setSelected(false);
                froyoObject.setPeach(false);
            }
        });

        mango.setOnClickListener(view13 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                    &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                mango.setSelected(true);
                froyoObject.setMango(true);
            }
            else if(!mango.isSelected()&& peach.isSelected()){
                mango.setSelected(true);
                froyoObject.setMango(true);
                peach.setSelected(false);
                froyoObject.setPeach(false);
            }
            else if(!mango.isSelected()&& kiwi.isSelected()){
                mango.setSelected(true);
                froyoObject.setMango(true);
                kiwi.setSelected(false);
                froyoObject.setKiwi(false);
            }
            else if(!mango.isSelected()&& blueberry.isSelected()){
                mango.setSelected(true);
                froyoObject.setMango(true);
                blueberry.setSelected(false);
                froyoObject.setBlueberry(false);
            }
            else if(!mango.isSelected()&& blackberry.isSelected()){
                mango.setSelected(true);
                froyoObject.setMango(true);
                blackberry.setSelected(false);
                froyoObject.setBlackberry(false);
            }
            else if(!mango.isSelected()&& strawberry.isSelected()){
                mango.setSelected(true);
                froyoObject.setMango(true);
                strawberry.setSelected(false);
                froyoObject.setStrawberry(false);
            }
            else {
                mango.setSelected(false);
                froyoObject.setMango(false);
            }
        });

        blueberry.setOnClickListener(view13 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                    &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                blueberry.setSelected(true);
                froyoObject.setBlueberry(true);
            }
            else if(!blueberry.isSelected()&& peach.isSelected()){
                blueberry.setSelected(true);
                froyoObject.setBlueberry(true);
                peach.setSelected(false);
                froyoObject.setPeach(false);
            }
            else if(!blueberry.isSelected()&& kiwi.isSelected()){
                blueberry.setSelected(true);
                froyoObject.setBlueberry(true);
                kiwi.setSelected(false);
                froyoObject.setKiwi(false);
            }
            else if(!blueberry.isSelected()&& mango.isSelected()){
                blueberry.setSelected(true);
                froyoObject.setBlueberry(true);
                mango.setSelected(false);
                froyoObject.setMango(false);
            }
            else if(!blueberry.isSelected()&& blackberry.isSelected()){
                blueberry.setSelected(true);
                froyoObject.setBlueberry(true);
                blackberry.setSelected(false);
                froyoObject.setBlackberry(false);
            }
            else if(!blueberry.isSelected()&& strawberry.isSelected()){
                blueberry.setSelected(true);
                froyoObject.setBlueberry(true);
                strawberry.setSelected(false);
                froyoObject.setStrawberry(false);
            }
            else {
                blueberry.setSelected(false);
                froyoObject.setBlueberry(false);
            }
        });

        strawberry.setOnClickListener(view13 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                    &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                strawberry.setSelected(true);
                froyoObject.setStrawberry(true);
            }
            else if(!strawberry.isSelected()&& peach.isSelected()){
                strawberry.setSelected(true);
                froyoObject.setStrawberry(true);
                peach.setSelected(false);
                froyoObject.setPeach(false);
            }
            else if(!strawberry.isSelected()&& mango.isSelected()){
                strawberry.setSelected(true);
                froyoObject.setStrawberry(true);
                mango.setSelected(false);
                froyoObject.setMango(false);
            }
            else if(!strawberry.isSelected()&& blueberry.isSelected()){
                strawberry.setSelected(true);
                froyoObject.setStrawberry(true);
                blueberry.setSelected(false);
                froyoObject.setBlueberry(false);
            }
            else if(!strawberry.isSelected()&& blackberry.isSelected()){
                strawberry.setSelected(true);
                froyoObject.setStrawberry(true);
                blackberry.setSelected(false);
                froyoObject.setBlackberry(false);
            }
            else if(!strawberry.isSelected()&& kiwi.isSelected()){
                strawberry.setSelected(true);
                froyoObject.setStrawberry(true);
                kiwi.setSelected(false);
                froyoObject.setKiwi(false);
            }
            else {
                strawberry.setSelected(false);
                froyoObject.setStrawberry(false);
            }
        });

        blackberry.setOnClickListener(view13 -> {
            if (!kiwi.isSelected()&&!peach.isSelected()&&!mango.isSelected()
                    &&!blueberry.isSelected()&& !blackberry.isSelected() && !strawberry.isSelected()){
                blackberry.setSelected(true);
                froyoObject.setBlackberry(true);
            }
            else if(!blackberry.isSelected()&& peach.isSelected()){
                blackberry.setSelected(true);
                froyoObject.setBlackberry(true);
                peach.setSelected(false);
                froyoObject.setPeach(false);
            }
            else if(!blackberry.isSelected()&& mango.isSelected()){
                blackberry.setSelected(true);
                froyoObject.setBlackberry(true);
                mango.setSelected(false);
                froyoObject.setMango(false);
            }
            else if(!blackberry.isSelected()&& blueberry.isSelected()){
                blackberry.setSelected(true);
                froyoObject.setBlackberry(true);
                blueberry.setSelected(false);
                froyoObject.setBlueberry(false);
            }
            else if(!blackberry.isSelected()&& kiwi.isSelected()){
                blackberry.setSelected(true);
                froyoObject.setBlackberry(true);
                kiwi.setSelected(false);
                froyoObject.setKiwi(false);
            }
            else if(!blackberry.isSelected()&& strawberry.isSelected()){
                blackberry.setSelected(true);
                froyoObject.setBlackberry(true);
                strawberry.setSelected(false);
                froyoObject.setStrawberry(false);
            }
            else {
                blackberry.setSelected(false);
                froyoObject.setBlackberry(false);
            }
        });

        apply.setOnClickListener(v -> {

        });
    }
}