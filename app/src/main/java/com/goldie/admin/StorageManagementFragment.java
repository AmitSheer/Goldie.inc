package com.goldie.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import com.goldie.R;
import com.goldie.admin.data.StorageExpandableListAdapter;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageManagementFragment extends Fragment {
    String[] IceCream, Waffle, Crepe, Froyo;
    List<String> groupList;
    List<String> childList;
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
        });
    }

    private Task<DocumentSnapshot> createArrays() {
        store_collection = new HashMap<>();
        groupList = new ArrayList<>();
        groupList.add("Ice Cream");
        groupList.add("Waffle");
        groupList.add("Crepe");
        groupList.add("Frozen Yogurt");
        IceCream = new String[]{"vanilla", "chocolate", "strawberry", "pistachio"};
        Waffle = new String[]{"classic", "coffee", "butter", "chocolate"};
        Crepe = new String[]{"white chocolate", "dark chocolate", "strawberry", "banana",
                "blueberry", "gummy bears", "oreo", "whipped cream", "sprinklers",
                "dark chocolate topping", "white chocolate topping"};
        Froyo = new String[]{"kiwi", "mango", "peach", "strawberry", "blueberry", "blackberry"};
        return fillUnitInStock("ice cream", IceCream).addOnCompleteListener(task -> {
            fillUnitInStock("waffle", Waffle).addOnCompleteListener(task1 -> {
                fillUnitInStock("crepe", Crepe).addOnCompleteListener(task2 -> {
                    fillUnitInStock("frozen yogurt", Froyo).addOnCompleteListener(task3 -> {

                    });
                });
            });
        });

    }

    private Task<DocumentSnapshot> fillUnitInStock(String product, String[] arr) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("stock").document(product);
        return docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (int i = 0; i < arr.length; i++) {
                    DocumentSnapshot doc = task.getResult();
                    assert doc != null;
                    if (doc.exists()) {
                        Long unitInStockS = (Long) doc.get(arr[i]);
                        arr[i] = arr[i] + ": " + unitInStockS;
                    }
                }
                for (String group : groupList) {
                    if (group.equals("Ice Cream")) {
                        loadChild(IceCream);
                    } else if (group.equals("Waffle")) {
                        loadChild(Waffle);
                    } else if (group.equals("Crepe")) {
                        loadChild(Crepe);
                    } else {
                        loadChild(Froyo);
                    }
                    store_collection.put(group, childList);
                }
            }
        });

    }
    private void loadChild(String[] product) {
        childList = new ArrayList<>();
        childList.addAll(Arrays.asList(product));
    }
}