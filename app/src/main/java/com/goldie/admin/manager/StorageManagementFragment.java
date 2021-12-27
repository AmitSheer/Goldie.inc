package com.goldie.admin.manager;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.goldie.R;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageManagementFragment extends Fragment {
    String[] IceCream, Waffle, Crepe, Froyo;
    List<String> groupList;
    Map<String, List<String>> store_collection;
    ExpandableListView expandableListView;
    StorageExpandableListAdapter expandableListAdapter;


    public StorageManagementFragment() {
        super(R.layout.fragment_storage_management);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createArrays().addOnCompleteListener(task -> {
            expandableListView = view.findViewById(R.id.exp_list_view_storage);
            expandableListAdapter = new StorageExpandableListAdapter(super.getContext(), groupList, store_collection);
            expandableListView.setAdapter(expandableListAdapter);
            expandableListAdapter.notifyDataSetChanged();
            expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                int lastExpandedPosition = -1;

                @Override
                public void onGroupExpand(int i) {
                    if (lastExpandedPosition != -1 && i != lastExpandedPosition) {
                        expandableListView.collapseGroup(lastExpandedPosition);
                    }
                    lastExpandedPosition = i;
                }
            });
            expandableListAdapter.notifyDataSetChanged();

        });
    }

    private Task<DocumentSnapshot> createArrays() {
        store_collection = new HashMap<>();
        groupList = new ArrayList<>();
        groupList.add("ice cream");
        groupList.add("waffle");
        groupList.add("crepe");
        groupList.add("frozen yogurt");
        return fillUnitInStock("ice cream", IceCream).continueWithTask(new Continuation<DocumentSnapshot, Task<DocumentSnapshot>>() {
            @Override
            public Task<DocumentSnapshot> then(@NonNull Task<DocumentSnapshot> task) throws Exception {
                 return fillUnitInStock("waffle", Waffle).continueWithTask(new Continuation<DocumentSnapshot, Task<DocumentSnapshot>>() {
                    @Override
                    public Task<DocumentSnapshot> then(@NonNull Task<DocumentSnapshot> task) throws Exception {
                         return fillUnitInStock("crepe", Crepe).continueWithTask(new Continuation<DocumentSnapshot, Task<DocumentSnapshot>>() {
                            @Override
                            public Task<DocumentSnapshot> then(@NonNull Task<DocumentSnapshot> task) throws Exception {
                                return  fillUnitInStock("frozen yogurt", Froyo);
                            }
                        });
                    }
                });
            }
        });

    }

    private Task<DocumentSnapshot> fillUnitInStock(String product, String[] arr) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("stock").document(product);
        return docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                List<String> list = new ArrayList<>();
                    DocumentSnapshot doc = task.getResult();
                    assert doc != null;
                    if (doc.exists()) {
                        Map<String, Object> map = doc.getData();
                        if (map != null) {
                            for (Map.Entry<String, Object> entry : map.entrySet()) {
                                list.add(entry.getKey()+": "+entry.getValue().toString());
                            }
                        }
                }
                store_collection.put(product, list);
            }
        });
    }
}