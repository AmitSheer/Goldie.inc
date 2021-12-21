package com.goldie.admin.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.goldie.R;
import com.goldie.shop.shoppingcart.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;



    public class OrderDetailsAdaptar extends BaseExpandableListAdapter {
        private Context context;
        ArrayList<Product> listGroup;
        // Map of the product id and an arraylist of all children's
        HashMap<String,ArrayList<String>> listChild;

        public OrderDetailsAdaptar(Context context, ArrayList<Product> listGroup, HashMap<String,ArrayList<String>> listChild){
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
            if(convertView==null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView =inflater.inflate(R.layout.expandable_order, null);
            }
            TextView textView = convertView.findViewById(R.id.Order_Textview);
            textView.setText(group.getItemName());
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            String child=(String) getChild(groupPosition,childPosition);
            if(convertView==null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView =inflater.inflate(R.layout.expendable_product, null);
            }
            TextView textView = convertView.findViewById(R.id.Product_TextView);
//            ImageView plus = convertView.findViewById(R.id.plus);
            textView.setText(child);
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }


