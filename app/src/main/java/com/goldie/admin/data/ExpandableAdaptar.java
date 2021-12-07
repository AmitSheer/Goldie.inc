package com.goldie.admin.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goldie.R;

import java.util.HashMap;

public class ExpandableAdaptar extends RecyclerView.Adapter<ExpandableAdaptar.ViewHolder> {

    private static int VIEW_TYPE_ORDER = 0;
    private static int VIEW_TYPE_PRODUCT = 1;
    boolean isExpanded = false;
    HashMap<String, String> order;

    public ExpandableAdaptar(HashMap<String, String> _order) {
        order = _order;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_ORDER) {
            return new ViewHolder.OrderViewHolder(layoutInflater.inflate(R.layout.expandable_order, parent, false));
        } else {
            return new ViewHolder.productViewHolder(layoutInflater.inflate(R.layout.expendable_product, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(holder.getClass()==ViewHolder.OrderViewHolder.class){
            
        }

    }

    @Override
    public int getItemCount() {
        if (isExpanded) {
            return order.size() + 1;
        } else {
            return 1;
        }
        //return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return VIEW_TYPE_ORDER;
        else {
            return VIEW_TYPE_PRODUCT;
        }
        //return super.getItemViewType(position);
    }

    static public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }

        static class OrderViewHolder extends ViewHolder {
            private TextView orderTextView;

            public OrderViewHolder(View v) {
                super(v);
                orderTextView = v.findViewById(R.id.Order_Textview);
            }
        }

        static class productViewHolder extends ViewHolder {
            private TextView productTextView;

            public productViewHolder(View v) {
                super(v);
                productTextView = v.findViewById(R.id.Product_TextView);
            }
        }
    }

}
