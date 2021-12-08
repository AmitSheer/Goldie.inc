package com.goldie.account;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.goldie.account.data.UserData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

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

    public static Task<AuthResult> Login(String email, String password){
        return fAuth.signInWithEmailAndPassword(email,password);
    }


    public static Task<AuthResult> Register(String email, String password, String full_name, String phone){
        return fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                addUserToDB(email, password, full_name, phone);
            }else{
                UserData.empty();
            }
        });
    }
    private static Task<Void> addUserToDB(String email, String password, String full_name, String phone){
        UUID uid = UUID.randomUUID();
        UserData.fill(full_name,password,email,phone, uid.toString());
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        return db.collection("users").document(email).set(UserData.toMap()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    Log.d(TAG, "DocumentSnapshot added with ID: " + email);
                }else {
                    Log.w(TAG, "Error adding document", task.getException());
                }
            }
        });
    }
}
