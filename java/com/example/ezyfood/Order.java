package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    public static final String MENU_ID_KEY = "menuId";

    private TextView textMenuName;
    private TextView textPrice;
    private ImageView imageView;
    private TextView textCounter;
    private ImageView minusBtn;
    private ImageView plusBtn;
    private ImageView back;
    private ImageView cart;
    private Button addBtn;
    private int counter;
    private int menuId;

    private View.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.minusBtn:
                    if(counter>0)
                    {
                        minusCounter();
                    }
                    break;
                case R.id.plusBtn:
                    plusCounter();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textMenuName = findViewById(R.id.textName);
        textPrice = findViewById(R.id.textPrice);
        imageView = findViewById(R.id.imageView2);
        textCounter = findViewById(R.id.textCounter);
        minusBtn = findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(clickListener);
        plusBtn = findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(clickListener);
        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(clickListener);
        back = findViewById(R.id.back);
        cart = findViewById(R.id.cart);


        Intent intent = getIntent();
        if(null != intent){
            menuId = intent.getIntExtra(MENU_ID_KEY, -1);
            if (menuId != -1){
                Menu incomingMenu = Utils.getInstance().getMenuById(menuId);
                if (null != incomingMenu){
                    setData(incomingMenu);
                    //Masukin data untuk passing ke arraylist baru
                    addOrder(incomingMenu);
                }
            }
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menuId < 20) {
                    Intent intent = new Intent(Order.this, DrinksActivity.class);
                    startActivity(intent);
                }
                if(menuId > 20 && menuId < 40){
                    Intent intent = new Intent(Order.this, SnacksActivity.class);
                    startActivity(intent);
                }
                if(menuId > 40 && menuId < 60){
                    Intent intent = new Intent(Order.this, FoodsActivity.class);
                    startActivity(intent);
                }
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Order.this, MyOrder.class);
                startActivity(intent);
            }
        });


    }

    //naro data ke order
    private void setData(Menu menu){
        textMenuName.setText(menu.getName());
        imageView.setImageResource(menu.getImage());
        textPrice.setText(String.valueOf(menu.getPrice()));
    }

    //Add Menu Order yang dipilih ke myOrder ArrayList
    private void addOrder(final Menu menu){
        ArrayList<Menu> myOrder = Utils.getInstance().getMyOrder();

        boolean existInMyOrder = false;

        for(Menu m: myOrder){
            if(m.getId() == menu.getId()){
                existInMyOrder = true;
            }
        }

        if(existInMyOrder){
            addBtn.setEnabled(false);
        }
        else {
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sqty = textCounter.getText().toString();
                    int qty = Integer.parseInt(sqty.trim());
                    String sprice = textPrice.getText().toString();
                    int price = Integer.parseInt(sprice.trim());
                    int totalPrice = price * qty;
                    menu.setTotalPrice(totalPrice);
                    if(qty != 0) {
                        menu.setQty(qty);
                        if (Utils.getInstance().addTomyOrder(menu)) {
                            Toast.makeText(Order.this, "Order Added", Toast.LENGTH_SHORT).show();
                            finish();
                            Intent intent = new Intent (Order.this, MyOrder.class);
                            intent.putExtra("qty", qty);
                            intent.putExtra("totalPrice",totalPrice);
                            finish();
                        } else {
                            Toast.makeText(Order.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                        }
                    } else if (qty == 0){
                        Toast.makeText(Order.this, "Quantity can't be 0", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void plusCounter(){
        counter++;
        textCounter.setText(counter + "");
    }

    private void minusCounter(){
        counter--;
        textCounter.setText(counter + "");
    }

    //back Button Press
    @Override
    public void onBackPressed() {
        if(menuId < 20) {
            Intent intent = new Intent(this, DrinksActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        if(menuId > 20 && menuId < 40) {
            Intent intent = new Intent(this, SnacksActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        if(menuId > 40 && menuId < 60) {
            Intent intent = new Intent(this, FoodsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

}