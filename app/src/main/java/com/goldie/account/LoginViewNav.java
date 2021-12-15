package com.goldie.account;

import android.app.Activity;
import android.content.Intent;

import com.goldie.shop.ShopActivity;
import com.goldie.account.data.UserData;
import com.goldie.admin.AdminMainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

import androidx.annotation.NonNull;

public class LoginViewNav  {
    /**
     * chage the view to the right one depending on the type of user currently logged in
     * @param activity the current activity
     */
    public static void ChangeViewByUserType(Activity activity){
        try {
            FirebaseAdapter.UpdateUserData().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        Intent intent;
                        if (UserData.IsAdmin && activity.getClass()!=AdminMainActivity.class) {
                            intent = new Intent(activity.getBaseContext(), AdminMainActivity.class);
                            activity.startActivity(intent);
                            activity.finish();
                        } else if(!UserData.IsAdmin && activity.getClass()!= ShopActivity.class){
                            intent = new Intent(activity.getBaseContext(), ShopActivity.class);
                            activity.startActivity(intent);
                            activity.finish();
                        }

                    }
                }
            });
        }catch(Exception e ){
            if(activity.getClass()!=LoginActivity.class) {
                Intent intent = new Intent(activity.getBaseContext(), LoginActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }
        }
    }
}
