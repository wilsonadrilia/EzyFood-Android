package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DrinksActivity extends AppCompatActivity {

    private RecyclerView drinksRecView;
    RecyclerView.LayoutManager layoutManager;
    MenuRecViewAdapter recyclerViewAdapter;
    private ImageView back;
    private ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        //RecView + LayoutManager
        drinksRecView = findViewById(R.id.drinksRecView);
        layoutManager = new GridLayoutManager(this,2);
        drinksRecView.setLayoutManager(layoutManager);
        //Adapter
        recyclerViewAdapter = new MenuRecViewAdapter(this, "drinks");
        drinksRecView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setMenu(Utils.getInstance().getDrinks());
        drinksRecView.setHasFixedSize(true);

        back = findViewById(R.id.back);
        cart = findViewById(R.id.cart);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinksActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinksActivity.this, MyOrder.class);
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