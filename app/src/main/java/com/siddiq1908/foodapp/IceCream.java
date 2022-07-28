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

public class IceCream extends AppCompatActivity {
    RecyclerView iceCreamRecycler;
    PizzaAdapter pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_cream);

        List<PizzaModel> pizzaList = new ArrayList<>();

        pizzaList.add(new PizzaModel(R.drawable.chocolate_icecream,"Chocolate Ice-cream","4.5","₹199","4.5"));
        pizzaList.add(new PizzaModel(R.drawable.strawberry_icecream,"Strawberry Ice-cream","4.8","₹149","4.8"));
        pizzaList.add(new PizzaModel(R.drawable.mango_icecream,"Mango Ice-cream","4.4","₹249","4.4"));
        pizzaList.add(new PizzaModel(R.drawable.kulfi,"Kulfi","4.2","₹50","4.2"));
        pizzaList.add(new PizzaModel(R.drawable.cornetto,"Cornetto","4.3","₹60","4.3"));
        setPizzaRecycler(pizzaList);
    }

    private void setPizzaRecycler(List<PizzaModel> pizzaList) {
        iceCreamRecycler = findViewById(R.id.iceCreamRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        iceCreamRecycler.setLayoutManager(layoutManager);
        pizzaAdapter = new PizzaAdapter(this,pizzaList);
        iceCreamRecycler.setAdapter(pizzaAdapter);
    }
}