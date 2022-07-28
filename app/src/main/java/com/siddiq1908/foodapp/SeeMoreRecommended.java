package com.siddiq1908.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.siddiq1908.foodapp.adapter.CategoryVerAdapter;
import com.siddiq1908.foodapp.adapter.SeeMoreCategoryAdapter;
import com.siddiq1908.foodapp.adapter.SeeMoreRecommendedAdapter;
import com.siddiq1908.foodapp.model.CategoryVerModel;
import com.siddiq1908.foodapp.model.RecommendedModel;
import com.siddiq1908.foodapp.model.SeeMoreCategoryModel;
import com.siddiq1908.foodapp.model.SeeMoreRecommendedModel;

import java.util.ArrayList;
import java.util.List;

public class SeeMoreRecommended extends AppCompatActivity {
    RecyclerView seeMoreRecommendedRecycler;
    SeeMoreRecommendedAdapter seeMoreRecommendedAdapter;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_more_recommended);

        back = findViewById(R.id.back_see_more_recommended);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeeMoreRecommended.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ArrayList<SeeMoreRecommendedModel> seeMoreRecommendedList = new ArrayList<>();
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.recommended1,"Pasta","3.2","₹49","3.2"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.recommended2,"Biryani","4.2","₹119", "4.2"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.recommended3,"Shawarma","4.5","₹85", "4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.cheese_pizza,"Cheese Pizza","4.5","₹129","4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.margherita_pizza,"Margherita Pizza","4.1","₹149","4.1"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.chicken_barbecue_pizza,"Chicken Barbecue Pizza","4.4","₹239","4.4"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.veg_loaded_pizza,"Veg Loaded Pizza","4.0","₹109","4.0"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.golden_corn_pizza,"Golden Corn Pizza","4.3","₹119","4.3"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.chicken_burger,"Chicken Burger","4.5","₹89","4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.veg_burger,"Veg Burger","4.2","₹59","4.2"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.cheese_burger,"Cheese Burger","4.4","₹79","4.4"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.aloo_burger,"Aloo Burger","4.0","₹49","4.0"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.egg_burger,"Egg Burger","4.1","₹75","4.1"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.mutton_biryani,"Mutton Biryani","4.5","₹129","4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.chicken_biryani,"Chicken Biryani","4.5","₹129","4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.hyderabad_biryani,"Hyderabadi Biryani","4.5","₹129","4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.moradabad_biryani,"Moradabadi Biryani","4.5","₹129","4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.veg_biryani,"Veg Biryani","4.5","₹129","4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.chocolate_cake,"Chocolate Cake","4.5","₹499","4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.vanilla_cake,"Vanilla Cake","4.8","₹449","4.8"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.red_velvet_cake,"Red Velvet Cake","4.4","₹549","4.4"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.pineapple_cake,"Pineapple Cake","4.2","₹399","4.2"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.butterscotch_cake,"Butterscotch Cake","4.3","₹429","4.3"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.chocolate_icecream,"Chocolate Ice-cream","4.5","₹199","4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.strawberry_icecream,"Strawberry Ice-cream","4.8","₹149","4.8"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.mango_icecream,"Mango Ice-cream","4.4","₹249","4.4"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.kulfi,"Kulfi","4.2","₹50","4.2"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.cornetto,"Cornetto","4.3","₹60","4.3"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.coke,"Coke","4.5","₹40","4.5"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.cold_coffee,"Cold Coffee","4.3","₹60","4.3"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.ice_tea,"Ice Tea","4.4","₹60","4.4"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.lemonade,"Lemonade","4.1","₹30","4.1"));
        seeMoreRecommendedList.add(new SeeMoreRecommendedModel(R.drawable.orange_juice,"Orange Juice","4.0","₹50","4.0"));

        setSeeMoreRecommendedRecycler(seeMoreRecommendedList);
    }

    private void setSeeMoreRecommendedRecycler(ArrayList<SeeMoreRecommendedModel> seeMoreRecommendedList) {
        seeMoreRecommendedRecycler = findViewById(R.id.seeMoreRecommendedRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        seeMoreRecommendedRecycler.setLayoutManager(layoutManager);
        seeMoreRecommendedAdapter = new SeeMoreRecommendedAdapter(this,seeMoreRecommendedList);
        seeMoreRecommendedRecycler.setAdapter(seeMoreRecommendedAdapter);
    }


}