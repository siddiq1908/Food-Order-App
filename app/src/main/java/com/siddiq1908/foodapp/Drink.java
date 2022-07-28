package com.siddiq1908.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.siddiq1908.foodapp.adapter.PizzaAdapter;
import com.siddiq1908.foodapp.model.CategoryVerModel;
import com.siddiq1908.foodapp.model.PizzaModel;

import java.util.ArrayList;
import java.util.List;

public class Drink extends AppCompatActivity {
    RecyclerView drinkRecycler;
    PizzaAdapter pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        List<PizzaModel> pizzaList = new ArrayList<>();

        pizzaList.add(new PizzaModel(R.drawable.coke,"Coke","4.5","₹40","4.5"));
        pizzaList.add(new PizzaModel(R.drawable.cold_coffee,"Cold Coffee","4.3","₹60","4.3"));
        pizzaList.add(new PizzaModel(R.drawable.ice_tea,"Ice Tea","4.4","₹60","4.4"));
        pizzaList.add(new PizzaModel(R.drawable.lemonade,"Lemonade","4.1","₹30","4.1"));
        pizzaList.add(new PizzaModel(R.drawable.orange_juice,"Orange Juice","4.0","₹50","4.0"));
        setPizzaRecycler(pizzaList);
    }

    private void setPizzaRecycler(List<PizzaModel> pizzaList) {
        drinkRecycler = findViewById(R.id.drinkRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        drinkRecycler.setLayoutManager(layoutManager);
        pizzaAdapter = new PizzaAdapter(this,pizzaList);
        drinkRecycler.setAdapter(pizzaAdapter);
    }
}