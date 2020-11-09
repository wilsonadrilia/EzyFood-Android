package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderCompleteActivity extends AppCompatActivity {

    private RecyclerView cartRecView;
    private RecyclerView.LayoutManager layoutManager;
    private OrderCompleteRecView recyclerViewAdapter;
    private TextView finalPrice;
    private ImageView home;
    private int totalSum = Utils.getInstance().finalPrice();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        //RecView + LayoutManager
        recyclerViewAdapter = new OrderCompleteRecView(this, "drinks");
        cartRecView = findViewById(R.id.cartRecView2);
        layoutManager = new LinearLayoutManager(this);
        cartRecView.setLayoutManager(layoutManager);
        finalPrice = findViewById(R.id.final_price);
        home = findViewById(R.id.home);

        //Adapter
        cartRecView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setMenu2(Utils.getInstance().getMyOrder());
        cartRecView.setHasFixedSize(true);

        finalPrice.setText(String.valueOf(totalSum));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompleteActivity.this,MainActivity.class);
                Utils.getMyOrder().clear();
                startActivity(intent);
            }
        });

    }
}