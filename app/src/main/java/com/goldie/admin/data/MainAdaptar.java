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

import com.goldie.shop.ShopActivity;


import com.goldie.R;
import com.goldie.shop.shoppingcart.Product;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents an adapter of extendable list - the group is the products and the children's are the toppings, addons, sizes, etc.
 */
public class MainAdaptar extends BaseExpandableListAdapter {
    Context context;
    // List of all products
    ArrayList<Product> listGroup;
    // Map of the product id and an arraylist of all children's
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

    // Used to inflate the products list so it will get the right number of rows
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Product group = (Product) getGroup(groupPosition);
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_order, null);
        }
        // Get from layout xml to present it in the text
        TextView textView = convertView.findViewById(R.id.list_parent);
        TextView priceView = convertView.findViewById(R.id.list_parent_price);
        ImageView deleteIconView = convertView.findViewById(R.id.icon_delete);
        String id = group.getProduct_id();
        // Separate the product name from the product id
        textView.setText(id.substring(0,id.indexOf('_')));
        priceView.setText("Price: "+group.getPrice()+"$");

        // Listens to delete icon being clicked
        deleteIconView.setOnClickListener(new View.OnClickListener() {
            // If clicked, build the alert dialog
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Product?");
                builder.setMessage("Do you want to remove current product?");
                builder.setCancelable(true);
                // If the user clicks accept - deletes the order from all places
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
                        ShopActivity.order.remove(productID);
                        // Lets the adapter know it needs to be refreshed
                        notifyDataSetChanged();
                    }
                });
                // If the user clicks cancel - cancel the alert dialog box
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.cancel();
                    }
                });
                // Create the alert dialog and present it
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return convertView;
    }

    // Used to inflate the children's list so it will get the right number of rows
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child=(String) getChild(groupPosition,childPosition);
        if(convertView==null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_product, null);
        }
        TextView textView = convertView.findViewById(R.id.list_child);
        textView.setText(child);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}