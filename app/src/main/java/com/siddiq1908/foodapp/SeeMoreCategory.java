package com.siddiq1908.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.siddiq1908.foodapp.adapter.SeeMoreCategoryAdapter;
import com.siddiq1908.foodapp.model.SeeMoreCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class SeeMoreCategory extends AppCompatActivity {

    RecyclerView seeMoreCategoryRecycler;
    SeeMoreCategoryAdapter seeMoreCategoryAdapter;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_more_category);

        back = findViewById(R.id.back_see_more_category);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeeMoreCategory.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        List<SeeMoreCategoryModel> seeMoreCategoryList = new ArrayList<>();
        seeMoreCategoryList.add(new SeeMoreCategoryModel(R.drawable.pizza,"Pizza"));
        seeMoreCategoryList.add(new SeeMoreCategoryModel(R.drawable.burger,"Burger"));
        seeMoreCategoryList.add(new SeeMoreCategoryModel(R.drawable.biryani,"Biryani"));
        seeMoreCategoryList.add(new SeeMoreCategoryModel(R.drawable.cake,"Cake"));
        seeMoreCategoryList.add(new SeeMoreCategoryModel(R.drawable.ice_cream,"Ice Cream"));
        seeMoreCategoryList.add(new SeeMoreCategoryModel(R.drawable.drink,"Drink"));

        setSeeMoreCategoryRecycler(seeMoreCategoryList);
    }

    private void setSeeMoreCategoryRecycler(List<SeeMoreCategoryModel> seeMoreCategoryList) {
        seeMoreCategoryRecycler = findViewById(R.id.seeMoreCategoryRecycler);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 3);
        seeMoreCategoryRecycler.setLayoutManager(layoutManager);
        seeMoreCategoryAdapter = new SeeMoreCategoryAdapter(this,seeMoreCategoryList);
        seeMoreCategoryRecycler.setAdapter(seeMoreCategoryAdapter);
    }
}