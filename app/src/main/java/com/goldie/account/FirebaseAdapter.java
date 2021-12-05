package com.goldie.account;

import android.annotation.SuppressLint;
import android.util.Log;

import com.goldie.account.data.UserData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;

public class FirebaseAdapter {
    private static final String TAG = "DocSnippets";

    public static FirebaseAuth fAuth = FirebaseAuth.getInstance();
    @SuppressLint("StaticFieldLeak")
    static FirebaseFirestore fDb = FirebaseFirestore.getInstance();

    public static Task<DocumentSnapshot> UpdateUserData(){
        return UpdateUserData(fAuth.getCurrentUser().getEmail());
    }

    public static Task<DocumentSnapshot> UpdateUserData(String email){
        DocumentReference docRef = fDb.collection("users").document(email);
        return docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        UserData.Email = email;
                        UserData.FullName = document.getString("fullname");
                        UserData.IsAdmin = document.getBoolean("isAdmin");
                        UserData.Phone = document.getString("phone");
                        UserData.Uid = document.getString("uid");
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
}
