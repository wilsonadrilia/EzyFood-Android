package com.example.ezyfood;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.ezyfood.Order.MENU_ID_KEY;



public class RecViewAdapterMyOrder extends RecyclerView.Adapter<RecViewAdapterMyOrder.ViewHolder> {

    private ArrayList<Menu> menu = new ArrayList<>();
    private Context mContext;
    private String mData;

    public RecViewAdapterMyOrder(Context mContext, String drinks) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myorder_view,parent,false);
        RecViewAdapterMyOrder.ViewHolder viewHolder = new RecViewAdapterMyOrder.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameOrder.setText(menu.get(position).getName());
        holder.imageOrder.setImageResource(menu.get(position).getImage());
        holder.price.setText(String.valueOf(menu.get(position).getPrice()));
        holder.qty.setText(String.valueOf(menu.get(position).getQty()));
        holder.totalPrice.setText(String.valueOf(menu.get(position).getTotalPrice()));

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("Are you sure you want to delete " + menu.get(position).getName() + "?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Utils.getInstance().removeFrommyOrder(menu.get(position))){
                            Intent intent = new Intent(mContext, MyOrder.class);
                            mContext.startActivity(intent);
                            Toast.makeText(mContext, "Menu Remove", Toast.LENGTH_SHORT).show();
                            notifyDataSetChanged();
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //No Dialog
                    }
                });
                builder.create().show();
            }
        });
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
        CardView orderParent;
        ImageView imageOrder, deleteBtn, multi, equal;
        TextView nameOrder, price, qty, totalPrice, final_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderParent = itemView.findViewById(R.id.orderParent);
            imageOrder = itemView.findViewById(R.id.imageOrder);
            nameOrder = itemView.findViewById(R.id.nameOrder);
            price = itemView.findViewById(R.id.price);
            multi = itemView.findViewById(R.id.multi);
            qty = itemView.findViewById(R.id.qty);
            equal = itemView.findViewById(R.id.equal);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            totalPrice = itemView.findViewById(R.id.totalprice);
            final_price = itemView.findViewById(R.id.final_price);
        }
    }

}



