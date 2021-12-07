package com.goldie.menu;

import static com.goldie.MainActivity.order;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.goldie.R;
import com.goldie.shoppingcart.Product;

public class FroyoMenuFragment extends Fragment {

    Button apply;
    ImageButton small, medium, large, kiwi, peach, mango, blueberry, strawberry, blackberry;
    boolean something_checked = false;
    FroyoObject frozen = new FroyoObject();


    public FroyoMenuFragment() {
        super(R.layout.fragment_froyo_menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
            } else if (!small.isSelected() && medium.isSelected()) {
                medium.setSelected(false);
                small.setSelected(true);
            } else if (!small.isSelected() && large.isSelected()) {
                large.setSelected(false);
                small.setSelected(true);
            } else {
                small.setSelected(false);
            }
        });

        medium.setOnClickListener(view1 -> {
            if (!medium.isSelected() && !small.isSelected() && !large.isSelected()) {
                medium.setSelected(true);
            } else if (!medium.isSelected() && small.isSelected()) {
                small.setSelected(false);
                medium.setSelected(true);
            } else if (!medium.isSelected() && large.isSelected()) {
                large.setSelected(false);
                medium.setSelected(true);
            } else {
                medium.setSelected(false);
            }
        });

        large.setOnClickListener(view1 -> {
            if (!medium.isSelected() && !small.isSelected() && !large.isSelected()) {
                large.setSelected(true);
            } else if (!large.isSelected() && small.isSelected()) {
                small.setSelected(false);
                large.setSelected(true);
            } else if (!large.isSelected() && medium.isSelected()) {
                medium.setSelected(false);
                large.setSelected(true);
            } else {
                large.setSelected(false);
            }
        });

        kiwi.setOnClickListener(view13 -> {
            if (!kiwi.isSelected() && !peach.isSelected() && !mango.isSelected()
                    && !blueberry.isSelected() && !blackberry.isSelected() && !strawberry.isSelected()) {
                kiwi.setSelected(true);
                something_checked = true;
            } else if (!kiwi.isSelected() && peach.isSelected()) {
                kiwi.setSelected(true);
                peach.setSelected(false);
            } else if (!kiwi.isSelected() && mango.isSelected()) {
                kiwi.setSelected(true);
                mango.setSelected(false);
            } else if (!kiwi.isSelected() && blueberry.isSelected()) {
                kiwi.setSelected(true);
                blueberry.setSelected(false);
            } else if (!kiwi.isSelected() && strawberry.isSelected()) {
                kiwi.setSelected(true);
                strawberry.setSelected(false);
            } else if (!kiwi.isSelected() && blackberry.isSelected()) {
                kiwi.setSelected(true);
                blackberry.setSelected(false);
            } else {
                kiwi.setSelected(false);
                something_checked = false;
            }
        });

        peach.setOnClickListener(view12 -> {
            if (!kiwi.isSelected() && !peach.isSelected() && !mango.isSelected()
                    && !blueberry.isSelected() && !blackberry.isSelected() && !strawberry.isSelected()) {
                peach.setSelected(true);
                something_checked = true;
            } else if (!peach.isSelected() && kiwi.isSelected()) {
                peach.setSelected(true);
                kiwi.setSelected(false);
            } else if (!peach.isSelected() && mango.isSelected()) {
                peach.setSelected(true);
                mango.setSelected(false);
            } else if (!peach.isSelected() && blueberry.isSelected()) {
                peach.setSelected(true);
                blueberry.setSelected(false);
            } else if (!peach.isSelected() && strawberry.isSelected()) {
                peach.setSelected(true);
                strawberry.setSelected(false);
            } else if (!peach.isSelected() && blackberry.isSelected()) {
                peach.setSelected(true);
                blackberry.setSelected(false);
            } else {
                peach.setSelected(false);
                something_checked = false;
            }
        });

        mango.setOnClickListener(view13 -> {
            if (!kiwi.isSelected() && !peach.isSelected() && !mango.isSelected()
                    && !blueberry.isSelected() && !blackberry.isSelected() && !strawberry.isSelected()) {
                mango.setSelected(true);
                something_checked = true;
            } else if (!mango.isSelected() && kiwi.isSelected()) {
                mango.setSelected(true);
                kiwi.setSelected(false);
            } else if (!mango.isSelected() && peach.isSelected()) {
                mango.setSelected(true);
                peach.setSelected(false);
            } else if (!mango.isSelected() && blueberry.isSelected()) {
                mango.setSelected(true);
                blueberry.setSelected(false);
            } else if (!mango.isSelected() && strawberry.isSelected()) {
                mango.setSelected(true);
                strawberry.setSelected(false);
            } else if (!mango.isSelected() && blackberry.isSelected()) {
                mango.setSelected(true);
                blackberry.setSelected(false);
            } else {
                mango.setSelected(false);
                something_checked = false;
            }
        });

        blueberry.setOnClickListener(view13 -> {
            if (!kiwi.isSelected() && !peach.isSelected() && !mango.isSelected()
                    && !blueberry.isSelected() && !blackberry.isSelected() && !strawberry.isSelected()) {
                blueberry.setSelected(true);
                something_checked = true;
            } else if (!blueberry.isSelected() && kiwi.isSelected()) {
                blueberry.setSelected(true);
                kiwi.setSelected(false);
            } else if (!blueberry.isSelected() && peach.isSelected()) {
                blueberry.setSelected(true);
                peach.setSelected(false);
            } else if (!blueberry.isSelected() && mango.isSelected()) {
                blueberry.setSelected(true);
                mango.setSelected(false);
            } else if (!blueberry.isSelected() && strawberry.isSelected()) {
                blueberry.setSelected(true);
                strawberry.setSelected(false);
            } else if (!blueberry.isSelected() && blackberry.isSelected()) {
                blueberry.setSelected(true);
                blackberry.setSelected(false);
            } else {
                blueberry.setSelected(false);
                something_checked = false;
            }
        });

        strawberry.setOnClickListener(view13 -> {
            if (!kiwi.isSelected() && !peach.isSelected() && !mango.isSelected()
                    && !blueberry.isSelected() && !blackberry.isSelected() && !strawberry.isSelected()) {
                strawberry.setSelected(true);
                something_checked = true;
            } else if (!strawberry.isSelected() && kiwi.isSelected()) {
                strawberry.setSelected(true);
                kiwi.setSelected(false);
            } else if (!strawberry.isSelected() && peach.isSelected()) {
                strawberry.setSelected(true);
                peach.setSelected(false);
            } else if (!strawberry.isSelected() && mango.isSelected()) {
                strawberry.setSelected(true);
                mango.setSelected(false);
            } else if (!strawberry.isSelected() && blueberry.isSelected()) {
                strawberry.setSelected(true);
                blueberry.setSelected(false);
            } else if (!strawberry.isSelected() && blackberry.isSelected()) {
                strawberry.setSelected(true);
                blackberry.setSelected(false);
            } else {
                strawberry.setSelected(false);
                something_checked = false;
            }
        });

        blackberry.setOnClickListener(view13 -> {
            if (!kiwi.isSelected() && !peach.isSelected() && !mango.isSelected()
                    && !blueberry.isSelected() && !blackberry.isSelected() && !strawberry.isSelected()) {
                blackberry.setSelected(true);
                something_checked = true;
            } else if (!blackberry.isSelected() && kiwi.isSelected()) {
                blackberry.setSelected(true);
                kiwi.setSelected(false);
            } else if (!blackberry.isSelected() && peach.isSelected()) {
                blackberry.setSelected(true);
                peach.setSelected(false);
            } else if (!blackberry.isSelected() && mango.isSelected()) {
                blackberry.setSelected(true);
                mango.setSelected(false);
            } else if (!blackberry.isSelected() && blueberry.isSelected()) {
                blackberry.setSelected(true);
                blueberry.setSelected(false);
            } else if (!blackberry.isSelected() && strawberry.isSelected()) {
                blackberry.setSelected(true);
                strawberry.setSelected(false);
            } else {
                blackberry.setSelected(false);
                something_checked = false;
            }
        });


        apply.setOnClickListener(v -> {
            if ((large.isSelected() || medium.isSelected() || small.isSelected()) && something_checked) {
                if (small.isSelected()) {
                    frozen.cupSize = "small";
                } else if (medium.isSelected()) {
                    frozen.cupSize = "medium";
                } else {
                    frozen.cupSize = "large";
                }
                if (kiwi.isSelected()) {
                    frozen.flavor = "kiwi";
                } else if (mango.isSelected()) {
                    frozen.cupSize = "mango";
                } else if (peach.isSelected()) {
                    frozen.cupSize = "peach";
                } else if (blueberry.isSelected()) {
                    frozen.cupSize = "blueberry";
                } else if (strawberry.isSelected()) {
                    frozen.cupSize = "strawberry";
                } else {
                    frozen.cupSize = "blackberry";
                }
                order.put(Product.product_id, frozen);
                Toast.makeText(requireActivity().getApplicationContext(), "Product added to shopping cart!", Toast.LENGTH_SHORT).show();
                NavDirections action = FroyoMenuFragmentDirections.actionFroyoMenuFragmentToMenuFragment();
                Navigation.findNavController(view).navigate(action);

            } else if (!something_checked) {
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick flavor!", Toast.LENGTH_SHORT).show();
            } else if (!large.isSelected() && !medium.isSelected() && !small.isSelected()) {
                Toast.makeText(requireActivity().getApplicationContext(), "Please pick cup size!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}