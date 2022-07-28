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

public class Burger extends AppCompatActivity {
    RecyclerView burgerRecycler;
    PizzaAdapter pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

        List<PizzaModel> pizzaList = new ArrayList<>();

        pizzaList.add(new PizzaModel(R.drawable.chicken_burger,"Chicken Burger","4.5","₹89","4.5"));
        pizzaList.add(new PizzaModel(R.drawable.veg_burger,"Veg Burger","4.2","₹59","4.2"));
        pizzaList.add(new PizzaModel(R.drawable.cheese_burger,"Cheese Burger","4.4","₹79","4.4"));
        pizzaList.add(new PizzaModel(R.drawable.aloo_burger,"Aloo Burger","4.0","₹49","4.0"));
        pizzaList.add(new PizzaModel(R.drawable.egg_burger,"Egg Burger","4.1","₹75","4.1"));
        setPizzaRecycler(pizzaList);
    }

    private void setPizzaRecycler(List<PizzaModel> pizzaList) {
        burgerRecycler = findViewById(R.id.burgerRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        burgerRecycler.setLayoutManager(layoutManager);
        pizzaAdapter = new PizzaAdapter(this,pizzaList);
        burgerRecycler.setAdapter(pizzaAdapter);
    }
}