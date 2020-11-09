package com.example.ezyfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderCompleteRecView extends RecyclerView.Adapter<OrderCompleteRecView.ViewHolder> {
    private ArrayList<Menu> menu = new ArrayList<>();
    private Context mContext;
    private String mData;

    public OrderCompleteRecView(Context mContext, String drinks) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public OrderCompleteRecView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ordercomplete_view,parent,false);
        OrderCompleteRecView.ViewHolder viewHolder = new OrderCompleteRecView.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderCompleteRecView.ViewHolder holder, int position) {
        holder.nameOrder.setText(menu.get(position).getName());
        holder.imageOrder.setImageResource(menu.get(position).getImage());
        holder.price.setText(String.valueOf(menu.get(position).getPrice()));
        holder.qty.setText(String.valueOf(menu.get(position).getQty()));
        holder.totalPrice.setText(String.valueOf(menu.get(position).getTotalPrice()));
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }

    public void setMenu2(ArrayList<Menu> menu) {
        this.menu = menu;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView ordercompleteParent;
        TextView final_price;
        ImageView imageOrder, multi, equal;
        TextView nameOrder, price, qty, totalPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ordercompleteParent = itemView.findViewById(R.id.ordercompleteParent);
            imageOrder = itemView.findViewById(R.id.imageOrder);
            nameOrder = itemView.findViewById(R.id.nameOrder);
            price = itemView.findViewById(R.id.price);
            multi = itemView.findViewById(R.id.multi);
            qty = itemView.findViewById(R.id.qty);
            equal = itemView.findViewById(R.id.equal);
            totalPrice = itemView.findViewById(R.id.totalprice);
            final_price = itemView.findViewById(R.id.final_price);
        }
    }
}
