package com.goldie.admin.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.goldie.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainAdaptar extends BaseExpandableListAdapter {
    Context context;
    ArrayList<String> listGroup;
    HashMap<String,ArrayList<String>> listChild;
    public MainAdaptar(Context context, ArrayList<String> listGroup, HashMap<String,ArrayList<String>> listChild){
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
        return listChild.get(listGroup.get(i)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChild.get(listGroup.get(groupPosition)).get(childPosition);
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
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
            TextView textView = convertView.findViewById(R.id.list_parent);
            //String sGroup = String.valueOf(getGroup(groupPosition));
            textView.setText(group);
//            textView.setTypeface(null, Typeface.BOLD);
//            textView.setTextColor(Color.BLUE);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child=(String) getChild(groupPosition,childPosition);
        if(convertView==null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        TextView textView = convertView.findViewById(R.id.list_child);
        //String sGroup = String.valueOf(getGroup(groupPosition));
        textView.setText(child);
//            textView.setTypeface(null, Typeface.BOLD);
//            textView.setTextColor(Color.BLUE);

        return convertView;



//        convertView=LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item,parent,false);
//        TextView textView=convertView.findViewById(android.R.id.text1);
//        String sChild=String.valueOf(getChild(groupPosition,childPosition));
//        textView.setText(sChild);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(parent.getContext(),sChild,Toast.LENGTH_SHORT).show();
//            }
//        });

        //return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
