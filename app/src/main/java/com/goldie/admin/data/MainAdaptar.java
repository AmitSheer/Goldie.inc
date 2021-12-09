package com.goldie.admin.data;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.goldie.MainActivity;


import com.goldie.R;
import com.goldie.shoppingcart.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class MainAdaptar extends BaseExpandableListAdapter {
    Context context;
    ArrayList<Product> listGroup;
    HashMap<String,ArrayList<String>> listChild;

    public MainAdaptar(Context context, ArrayList<Product> listGroup, HashMap<String,ArrayList<String>> listChild){
        this.context=context;
        this.listGroup=listGroup;
        this.listChild=listChild;
    }
    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int i) {
        String child=listGroup.get(i).getProduct_id();
        return listChild.get(child).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String child=listGroup.get(groupPosition).getProduct_id();
        return listChild.get(child).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Product group = (Product) getGroup(groupPosition);
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_order, null);
        }
        TextView textView = convertView.findViewById(R.id.list_parent);
        TextView priceView = convertView.findViewById(R.id.list_parent_price);
        ImageView deleteIconView = convertView.findViewById(R.id.icon_delete);
        String id = group.getProduct_id();
        textView.setText(id.substring(0,id.indexOf('_')));
        priceView.setText("Price: "+group.getPrice()+"$");

        deleteIconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Order?");
                builder.setMessage("Do you want to remove current order?");
                builder.setCancelable(true);
                builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        Product product = listGroup.get(groupPosition);
                        // Get product name and product id to remove it properly
                        String productName = product.getItemName();
                        String productID = product.getProduct_id();
                        // Remove the product name from child with the array and remove the product from the group position
                        listChild.remove(productName);
                        listGroup.remove(groupPosition);
                        // Remove from the order hashmap (in class MainActivity) using productID
                        MainActivity.order.remove(productID);
                        // Lets the adapter know it needs to be refresed
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child=(String) getChild(groupPosition,childPosition);
        if(convertView==null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_product, null);
        }
        TextView textView = convertView.findViewById(R.id.list_child);
        textView.setText(child);
        //textView.setBackgroundColor(Color.TRANSPARENT);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}