package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TopUpActivity extends AppCompatActivity {

    private CardView limapuluh, seratus, seratuslimapuluh, duaratus, duaratuslimapuluh, tigaratus;
    private TextView balance;
    private ImageView back, cart;
    private int totalBalance = Utils.getBalance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        initViews();

        String total = String.valueOf(totalBalance);
        balance.setText("Rp. " + total);

        limapuluh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopUpActivity.this, MainActivity.class);
                totalBalance = totalBalance + 50000;
                Utils.setBalance(totalBalance);
                startActivity(intent);
            }
        });

        seratus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopUpActivity.this, MainActivity.class);
                totalBalance = totalBalance + 100000;
                Utils.setBalance(totalBalance);
                startActivity(intent);
            }
        });

        seratuslimapuluh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopUpActivity.this, MainActivity.class);
                totalBalance = totalBalance + 150000;
                Utils.setBalance(totalBalance);
                startActivity(intent);
            }
        });

        duaratus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopUpActivity.this, MainActivity.class);
                totalBalance = totalBalance + 200000;
                Utils.setBalance(totalBalance);
                startActivity(intent);
            }
        });

        duaratuslimapuluh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopUpActivity.this, MainActivity.class);
                totalBalance = totalBalance + 250000;
                Utils.setBalance(totalBalance);
                startActivity(intent);
            }
        });

        tigaratus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopUpActivity.this, MainActivity.class);
                totalBalance = totalBalance + 300000;
                Utils.setBalance(totalBalance);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopUpActivity.this, MyOrder.class);
                startActivity(intent);
            }
        });

        Utils.getInstance();
    }

    private void initViews(){
        limapuluh = findViewById(R.id.limapuluh);
        seratus = findViewById(R.id.seratus);
        seratuslimapuluh = findViewById(R.id.seratuslimapuluh);
        duaratus = findViewById(R.id.duaratus);
        duaratuslimapuluh = findViewById(R.id.duaratuslimapuluh);
        tigaratus = findViewById(R.id.tigaratus);
        balance = findViewById(R.id.balance);
        back = findViewById(R.id.back);
        cart = findViewById(R.id.cart);
    }
}