package com.goldie.admin.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goldie.R;

import java.lang.reflect.Method;
import java.util.List;

public class ExpandableAdaptar extends RecyclerView.Adapter<ExpandableAdaptar.ViewHolder> {

    private static int VIEW_TYPE_ORDER = 0;
    private static int VIEW_TYPE_PRODUCT = 1;
    static boolean isExpanded = false;
    List<String> order;
    public String order_id;
    public ExpandableAdaptar(List<String> _order,String _order_id) {
        order = _order;
        this.order_id=_order_id;
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
            ((ViewHolder.OrderViewHolder) holder).onBind(order_id);
        }
        if(holder.getClass()==ViewHolder.productViewHolder.class){
            ((ViewHolder.productViewHolder) holder).onBind(order.get(position-1));
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
//    private void onOrderClick(){
//        View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isExpanded=!isExpanded;
//                if(isExpanded){
//                    notifyItemRangeChanged(1,order.size());
//                    notifyItemChanged(0);
//                }
//                else{
//                    notifyItemRangeRemoved(1,order.size());
//                    notifyItemChanged(0);
//                }
//            }
//
//        };
//    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }

        public class OrderViewHolder extends ViewHolder {
            private TextView orderTextView;
            View v;
            public OrderViewHolder(View v) {
                super(v);
                this.v=v;
                orderTextView = v.findViewById(R.id.Order_Textview);
            }
            void onBind(String order_num){
            orderTextView.setText(order_num);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isExpanded=!isExpanded;
                    if(isExpanded){
                        notifyItemRangeChanged(1,order.size());
                        notifyItemChanged(0);
                    }
                    else{
                        notifyItemRangeRemoved(1,order.size());
                        notifyItemChanged(0);
                    }
                }
            });
            }
        }

        static class productViewHolder extends ViewHolder {
            private TextView productTextView;

            public productViewHolder(View v) {
                super(v);
                productTextView = v.findViewById(R.id.Product_TextView);
            }
            void onBind(String product){
                productTextView.setText(product);
            }
        }
    }

}
