package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyOrder extends AppCompatActivity {

    public static final String MENU_ID_KEY = "menuId";
    private RecyclerView cartRecView;
    private RecyclerView.LayoutManager layoutManager;
    private RecViewAdapterMyOrder recyclerViewAdapter;
    private int menuId;
    private ImageView back;
    private TextView balance_myorder, finalPrice;
    private Button btn_payment, btn_topup;
    private int totalSum = Utils.getInstance().finalPrice();
    private int balance = Utils.getBalance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);


        //RecView + LayoutManager
        recyclerViewAdapter = new RecViewAdapterMyOrder(this, "drinks");
        cartRecView = findViewById(R.id.cartRecView);
        layoutManager = new LinearLayoutManager(this);
        cartRecView.setLayoutManager(layoutManager);
        finalPrice = findViewById(R.id.final_price);
        balance_myorder = findViewById(R.id.balance_myorder);
        btn_payment = findViewById(R.id.btn_payment);
        btn_topup = findViewById(R.id.btn_topup);
        back = findViewById(R.id.back);

        //Adapter
        cartRecView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setMenu2(Utils.getInstance().getMyOrder());
        cartRecView.setHasFixedSize(true);
        balance_myorder.setText(String.valueOf(balance));
        finalPrice.setText(String.valueOf(totalSum));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (balance > totalSum){
                    Intent intent = new Intent(MyOrder.this, OrderCompleteActivity.class);
                    balance = balance - totalSum;
                    Utils.setBalance(balance);
                    startActivity(intent);
                } else if (balance < totalSum){
                    Toast.makeText(MyOrder.this, "Your Balance is not enough, please recharge first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyOrder.this, TopUpActivity.class);
                startActivity(intent);
            }
        });
    }

}