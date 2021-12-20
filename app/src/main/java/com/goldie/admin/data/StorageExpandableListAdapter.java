package com.goldie.admin.data;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.goldie.R;
import com.goldie.admin.StorageManagementFragment;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StorageExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private Map<String, List<String>> store_collection;
    private List<String> groupList;

    public StorageExpandableListAdapter(Context context, List<String> groupList, Map<String, List<String>> store_collection){
        this.context=context;
        this.store_collection=store_collection;
        this.groupList=groupList;
    }

    @Override
    public int getGroupCount() {
        return store_collection.size();
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
        ImageView plus = convertView.findViewById(R.id.plus);
        item.setText(product);
        //need to send to another page
//        plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder  = new AlertDialog.Builder(context){
//                    //
//
//                }
//            }
//        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
