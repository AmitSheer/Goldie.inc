package com.goldie.admin.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goldie.R;
import com.goldie.admin.delivery.DeliveryMenuFragmentDirections;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<String> orders = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String order_id=orders.get(position);
        holder.textView.setText(order_id);
    }

    @Override
    public int getItemCount() {
        if (orders != null)
            return orders.size();
        return 0;
    }
    public DeliveryAdapter(Context context, ArrayList<String> order_list){
        orders=order_list;
        this.context = context;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textView = (TextView) view.findViewById(R.id.list_child);
            view.setOnClickListener(this);
        }

        public TextView getTextView() {
            return textView;
        }


        @Override
        public void onClick(View v) {
            NavDirections action = DeliveryMenuFragmentDirections.actionDeliveryMenuFragmentToDeliveryDetailsFragment(textView.getText().toString());
            Navigation.findNavController(v).navigate(action);
        }
    }
}
