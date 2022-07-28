package com.siddiq1908.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siddiq1908.foodapp.adapter.PizzaAdapter;
import com.siddiq1908.foodapp.adapter.SeeMoreRecommendedAdapter;
import com.siddiq1908.foodapp.model.CategoryVerModel;
import com.siddiq1908.foodapp.model.PizzaModel;
import com.siddiq1908.foodapp.model.SeeMoreRecommendedModel;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends AppCompatActivity {
    RecyclerView pizzaRecycler;
    PizzaAdapter pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        List<PizzaModel> pizzaList = new ArrayList<>();

        pizzaList.add(new PizzaModel(R.drawable.cheese_pizza,"Cheese Pizza","4.5","₹129","4.5"));
        pizzaList.add(new PizzaModel(R.drawable.margherita_pizza,"Margherita Pizza","4.1","₹149","4.1"));
        pizzaList.add(new PizzaModel(R.drawable.chicken_barbecue_pizza,"Chicken Barbecue Pizza","4.4","₹239","4.4"));
        pizzaList.add(new PizzaModel(R.drawable.veg_loaded_pizza,"Veg Loaded Pizza","4.0","₹109","4.0"));
        pizzaList.add(new PizzaModel(R.drawable.golden_corn_pizza,"Golden Corn Pizza","4.3","₹119","4.3"));
        setPizzaRecycler(pizzaList);
    }

    private void setPizzaRecycler(List<PizzaModel> pizzaList) {
        pizzaRecycler = findViewById(R.id.pizzaRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        pizzaRecycler.setLayoutManager(layoutManager);
        pizzaAdapter = new PizzaAdapter(this,pizzaList);
        pizzaRecycler.setAdapter(pizzaAdapter);
    }
}