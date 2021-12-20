package com.goldie.admin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.goldie.R;
import com.goldie.admin.data.StorageExpandableListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageManagementFragment extends Fragment {
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> store_collection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;


    public StorageManagementFragment() {
        super(R.layout.fragment_storage_management);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createGroupList();
        createCollection();
        expandableListView = view.findViewById(R.id.exp_list_view_storage);
        expandableListAdapter = new StorageExpandableListAdapter(super.getContext(), groupList, store_collection);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;
            @Override
            public void onGroupExpand(int i) {
                if (lastExpandedPosition!=-1&&i!=lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition=i;
            }
        });
    }

    private void createCollection() {
        String[] IceCream= {"Vanilla", "Chocolate", "Strawberry", "Pistachio"};
        String[] Waffle= {"Classic", "Coffe", "Butter", "Chocolate"};
        String[] Crepe= {"White Chocolate", "Dark Chocolate", "Strawberry", "Banana",
        "Blueberry", "Gummy Bears", "Oreo", "Whipped Cream", "Sprinklers",
                "Dark Chocolate Top", "White Chocolate Top"};
        String[] Froyo= {"Kiwi", "Mango", "Peach", "Strawberry", "Blueberry", "Blackberry"};
        store_collection= new HashMap<String,List<String>>();
        for (String group: groupList){
            if (group.equals("Ice Cream")){
                loadChild(IceCream);
            }
            else if (group.equals("Waffle")){
                loadChild(Waffle);
            }
            else if (group.equals("Crepe")){
                loadChild(Crepe);
            }
            else {
                loadChild(Froyo);
            }
            store_collection.put(group, childList);
        }

    }

    private void loadChild(String[] product) {
        childList= new ArrayList<>();
        for (String pro:product){
            childList.add(pro);
        }
    }

    private void createGroupList() {
        groupList = new ArrayList<>();
        groupList.add("Ice Cream");
        groupList.add("Waffle");
        groupList.add("Crepe");
        groupList.add("Frozen Yogurt");

    }
}
