package com.goldie.admin.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

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

        return listGroup.get(groupPosition).getProduct_id();
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
        String group=(String) getGroup(groupPosition);
        if(convertView==null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_order, null);
        }
            TextView textView = convertView.findViewById(R.id.list_parent);
            textView.setText(group.substring(0,group.indexOf('_')));
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
