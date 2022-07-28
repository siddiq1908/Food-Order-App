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

public class Cake extends AppCompatActivity {
    RecyclerView cakeRecycler;
    PizzaAdapter pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);

        List<PizzaModel> pizzaList = new ArrayList<>();

        pizzaList.add(new PizzaModel(R.drawable.chocolate_cake,"Chocolate Cake","4.5","₹499","4.5"));
        pizzaList.add(new PizzaModel(R.drawable.vanilla_cake,"Vanilla Cake","4.8","₹449","4.8"));
        pizzaList.add(new PizzaModel(R.drawable.red_velvet_cake,"Red Velvet Cake","4.4","₹549","4.4"));
        pizzaList.add(new PizzaModel(R.drawable.pineapple_cake,"Pineapple Cake","4.2","₹399","4.2"));
        pizzaList.add(new PizzaModel(R.drawable.butterscotch_cake,"Butterscotch Cake","4.3","₹429","4.3"));
        setPizzaRecycler(pizzaList);
    }

    private void setPizzaRecycler(List<PizzaModel> pizzaList) {
        cakeRecycler = findViewById(R.id.cakeRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        cakeRecycler.setLayoutManager(layoutManager);
        pizzaAdapter = new PizzaAdapter(this,pizzaList);
        cakeRecycler.setAdapter(pizzaAdapter);
    }
}