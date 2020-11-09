package com.example.ezyfood;

import java.util.ArrayList;

//THIS IS LOCAL DATABASE WITH ONLY USING PASSING DATA.
public class Utils {

    private static Utils instance;

    private static ArrayList<Menu> drinks;
    private static ArrayList<Menu> snacks;
    private static ArrayList<Menu> foods;
    private static ArrayList<Menu> orders;
    private static ArrayList<Menu> myOrder;
    private static ArrayList<Menu> orderComplete;
    private static int balance;

    private Utils(){
        if (null == drinks){
            drinks = new ArrayList<>();
            initData();
        }

        if (null == snacks){
            snacks = new ArrayList<>();
            initDataSnacks();
        }

        if (null == foods){
            foods = new ArrayList<>();
            initDataFoods();
        }

        if (null == orders){
            orders = new ArrayList<>();
        }

        if (null == myOrder){
            myOrder = new ArrayList<>();
        }

        if (null == orderComplete){
            orderComplete = new ArrayList<>();
        }
    }

    private void initData(){
        //TODO: add initial data
        //Drinks Data
        drinks.add(new Menu(1,"Air Mineral",8000,R.drawable.drinks1,0,0));
        drinks.add(new Menu(2,"Jus Apel",15000,R.drawable.drinks2,0,0));
        drinks.add(new Menu(3,"Jus Alpukat",20000,R.drawable.drinks3,0,0));
        drinks.add(new Menu(4,"Jus Mangga",15000,R.drawable.drinks4,0,0));
        drinks.add(new Menu(5,"Jus Melon",15000,R.drawable.drinks5,0,0));
        drinks.add(new Menu(6,"Jus Jeruk",15000,R.drawable.drinks11,0,0));
        drinks.add(new Menu(7,"Coca Cola",10000,R.drawable.drinks7,0,0));
        drinks.add(new Menu(8,"Milkshake",20000,R.drawable.drinks8,0,0));
        drinks.add(new Menu(9,"Oreo Milk",20000,R.drawable.drinks9,0,0));
        drinks.add(new Menu(10,"Es Kelapa",12000,R.drawable.drinks10,0,0));
        drinks.add(new Menu(11,"Es Cincau",20000,R.drawable.drinks6,0,0));
        drinks.add(new Menu(12,"Kopi Susu",15000,R.drawable.drinks12,0,0));
    }

    private void initDataSnacks(){
        //Snacks Data
        snacks.add(new Menu(21,"Kentang Goreng", 20000,R.drawable.snacks1,0,0));
        snacks.add(new Menu(22,"Jamur Crispy", 20000,R.drawable.snacks7,0,0));
        snacks.add(new Menu(23,"Roti Bakar", 20000,R.drawable.snacks2,0,0));
        snacks.add(new Menu(24,"Pisang Bakar", 25000,R.drawable.snacks3,0,0));
        snacks.add(new Menu(25,"Risoles Ayam", 7000,R.drawable.snacks4,0,0));
        snacks.add(new Menu(26,"Pastel Ayam", 7000,R.drawable.snacks5,0,0));
        snacks.add(new Menu(27,"Bakwan Jagung", 5000,R.drawable.snacks8,0,0));
        snacks.add(new Menu(28,"Sosis Goreng", 25000,R.drawable.snacks10,0,0));
        snacks.add(new Menu(29,"Chicken Pok Pok", 30000,R.drawable.snacks6,0,0));
        snacks.add(new Menu(30,"Chicken Wings", 30000,R.drawable.snacks9,0,0));
    }

    private void initDataFoods(){
        //Foods Data
        foods.add(new Menu(41,"Nasi Goreng", 30000,R.drawable.foods1,0,0));
        foods.add(new Menu(42,"Nasi Kuning", 20000,R.drawable.foods2,0,0));
        foods.add(new Menu(43,"Soto Betawi", 30000,R.drawable.foods3,0,0));
        foods.add(new Menu(44,"Soto Ayam", 25000,R.drawable.foods4,0,0));
        foods.add(new Menu(45,"Sate Ayam @10pcs", 30000,R.drawable.foods5,0,0));
        foods.add(new Menu(46,"Ayam Goreng", 15000,R.drawable.foods6,0,0));
        foods.add(new Menu(47,"Bakmie Ayam", 25000,R.drawable.foods7,0,0));
        foods.add(new Menu(48,"Bakso Kuah", 25000,R.drawable.foods8,0,0));
        foods.add(new Menu(49,"Ketoprak", 20000,R.drawable.foods9,0,0));
        foods.add(new Menu(50,"Sayur Asem", 15000,R.drawable.foods10,0,0));
        foods.add(new Menu(51,"Nasi Putih", 5000,R.drawable.foods11,0,0));
        foods.add(new Menu(52,"Telur Goreng Dadar", 7000,R.drawable.foods12,0,0));
    }

    public static Utils getInstance() {
        if (null != instance){
            return instance;
        } else{
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Menu> getDrinks() { return drinks; }

    public static ArrayList<Menu> getSnacks() {
        return snacks;
    }

    public static ArrayList<Menu> getFoods() {
        return foods;
    }

    public static ArrayList<Menu> getOrders() {
        return orders;
    }

    public static ArrayList<Menu> getMyOrder() {
        return myOrder;
    }

    public static ArrayList<Menu> getOrderComplete() {
        return orderComplete;
    }

    public static int getBalance() {
        return balance;
    }

    public static void setBalance(int balance) {
        Utils.balance = balance;
    }

    public Menu getMenuById (int id){
        if(id > 0 && id < 15) {
            for (Menu m : drinks) {
                if (m.getId() == id)
                    return m;
            }
        }
        if (id > 15 && id <= 30){
            for (Menu m : snacks) {
                if (m.getId() == id)
                    return m;
            }
        }
        if (id > 40 && id < 60){
            for (Menu m : foods){
                if (m.getId() == id)
                    return m;
            }
        }
        return null;
    }

    public Menu myOrderId (int id){
        for (Menu m: myOrder){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public int finalPrice(){
        int sum = 0;
        for (int i = 0; i<myOrder.size(); i++) {
            sum = sum + myOrder.get(i).getTotalPrice();
        }
        return sum;
    }


//    public int final_price (Menu menu){
//        for(int i = 0; i<myOrder.size();i++){
//            int totalPrice = menu.getTotalPrice();
//            totalPrice += totalPrice;
//        }
//        return totalPrice;
//    }



    public boolean addToDrinks (Menu menu){
        return drinks.add(menu);
    }

    public boolean addToSnacks (Menu menu){
        return snacks.add(menu);
    }

    public boolean addToFoods (Menu menu){
        return foods.add(menu);
    }

    public boolean addToOrders (Menu menu){
        return orders.add(menu);
    }

    public boolean addTomyOrder (Menu menu){
        return myOrder.add(menu);
    }

    public boolean orderComplete (Menu menu){
        return orderComplete.add(menu);
    }

    public boolean removeFrommyOrder(Menu menu){
        return myOrder.remove(menu);
    }



}
