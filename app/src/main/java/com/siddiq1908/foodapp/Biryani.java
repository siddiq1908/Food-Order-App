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

public class Biryani extends AppCompatActivity {
    RecyclerView biryaniRecycler;
    PizzaAdapter pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biryani);

        List<PizzaModel> pizzaList = new ArrayList<>();

        pizzaList.add(new PizzaModel(R.drawable.mutton_biryani,"Mutton Biryani","4.5","₹129","4.5"));
        pizzaList.add(new PizzaModel(R.drawable.chicken_biryani,"Chicken Biryani","4.5","₹129","4.5"));
        pizzaList.add(new PizzaModel(R.drawable.hyderabad_biryani,"Hyderabadi Biryani","4.5","₹129","4.5"));
        pizzaList.add(new PizzaModel(R.drawable.moradabad_biryani,"Moradabadi Biryani","4.5","₹129","4.5"));
        pizzaList.add(new PizzaModel(R.drawable.veg_biryani,"Veg Biryani","4.5","₹129","4.5"));
        setPizzaRecycler(pizzaList);
    }

    private void setPizzaRecycler(List<PizzaModel> pizzaList) {
        biryaniRecycler = findViewById(R.id.biryaniRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        biryaniRecycler.setLayoutManager(layoutManager);
        pizzaAdapter = new PizzaAdapter(this,pizzaList);
        biryaniRecycler.setAdapter(pizzaAdapter);
    }
}