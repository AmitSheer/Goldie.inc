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

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StorageExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private Map<String, List<String>> store_collection;
    private List<String> groupList;
    private TextView tv;
    static Dialog d;

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
        String product = store_collection.get(groupList.get(groupPosition)).get(childPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.plus_item,null);
        }
        TextView item = convertView.findViewById(R.id.productName);
        item.setText(product);
        ImageView plus = convertView.findViewById(R.id.plus);
        //need to send to another page
        plus.setOnClickListener(new View.OnClickListener() {
            // If clicked, moves to different activity
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Add to stock");
                builder.setCancelable(true);
                final NumberPicker numberPicker = new NumberPicker(context);
                builder.setView(numberPicker);
                numberPicker.setMaxValue(360);
                numberPicker.setMinValue(0);
                numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                    }
                });
                builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {

                    }});
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.cancel();
                    }});
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
