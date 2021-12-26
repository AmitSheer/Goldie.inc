package com.goldie.admin.delivery;

import com.goldie.shop.shoppingcart.Order;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;


public class DeliveryDetailsController {
    private Order deliveryOrder;
    private DatabaseReference mDataset = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference delivery_ref=mDataset.child("Deliveries");
    private DeliveryDetailsFragment detailsFragment;

    public DeliveryDetailsController(DeliveryDetailsFragment detailsFragment) {
        this.detailsFragment = detailsFragment;
    }

    public Task<DataSnapshot> loadDeliveryData(String orderId){
        return delivery_ref.child(orderId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                deliveryOrder = Order.parse_order(task);
                detailsFragment.updateData(deliveryOrder);
            }
        });
    }

    public void saveReceipt(String signatureSvg){
        DatabaseReference finish_ref = mDataset.child("Finished Orders").child(deliveryOrder.getOrder_id());
        finish_ref.child("order").setValue(deliveryOrder);
        finish_ref.child("signature").setValue(signatureSvg);
    }
}
