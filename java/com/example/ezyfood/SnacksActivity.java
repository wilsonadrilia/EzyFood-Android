package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SnacksActivity extends AppCompatActivity {

    private RecyclerView snacksRecView;
    RecyclerView.LayoutManager layoutManager;
    MenuRecViewAdapter recyclerViewAdapter;
    private ImageView back;
    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        //RecView + LayoutManager
        snacksRecView = findViewById(R.id.snacksRecView);
        layoutManager = new GridLayoutManager(this,2);
        snacksRecView.setLayoutManager(layoutManager);
        //Adapter
        recyclerViewAdapter = new MenuRecViewAdapter(this, "snacks");
        snacksRecView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setMenu(Utils.getInstance().getSnacks());
        snacksRecView.setHasFixedSize(true);

        back = findViewById(R.id.back);
        cart = findViewById(R.id.cart);

        //back <--
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SnacksActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //shopping cart image
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SnacksActivity.this, MyOrder.class);
                startActivity(intent);
            }
        });
    }

    //back Button Press
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}