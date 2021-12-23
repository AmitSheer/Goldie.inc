package com.goldie.admin;//package com.goldie.admin.data;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.goldie.R;
import com.goldie.admin.StorageManagementFragment;
import com.goldie.shop.ShopActivity;
import com.goldie.shop.shoppingcart.Product;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StorageExpandableListAdapter extends BaseExpandableListAdapter {
    private final Context context;
    private final Map<String, List<String>> store_collection;
    private final List<String> groupList;
    private int add , inStock;
    public StorageExpandableListAdapter(Context context, List<String> groupList, Map<String, List<String>> store_collection){
        this.context=context;
        this.store_collection=store_collection;
        this.groupList=groupList;
    }

    @Override
    public int getGroupCount() {
        if (store_collection!=null) {
            return store_collection.size();
        }
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return Objects.requireNonNull(store_collection.get(groupList.get(groupPosition))).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return store_collection.get(groupList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String productName = groupList.get(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.storage_product,null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.product);
        textView.setText(productName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String str = store_collection.get(groupList.get(groupPosition)).get(childPosition);
        String[] strings = str.split(": ");
        String product= strings[0];
        inStock = Integer.parseInt(strings[1]);
        String mainProduct = groupList.get(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.plus_item,null);
        }
        TextView item = convertView.findViewById(R.id.productName);
        item.setText(product);
        ImageView plus = convertView.findViewById(R.id.plus);
        //need to send to another page
        String finalProduct = product;
        plus.setOnClickListener(new View.OnClickListener() {
            // If clicked, moves to different activity
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Add to stock");
                builder.setCancelable(true);
                final NumberPicker numberPicker = new NumberPicker(context);
                builder.setView(numberPicker);
                numberPicker.setMaxValue(500);
                numberPicker.setMinValue(0);
                numberPicker.setOnValueChangedListener((picker, oldVal, newVal) -> add =newVal);
                builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                        DocumentReference docRef = db.collection("stock").document(mainProduct);
                        inStock+=add;
                        add=0;
                        docRef.update(finalProduct,inStock+add);
                    }});
                builder.setNegativeButton("Cancel", (dialogInterface, id) -> dialogInterface.cancel());
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
