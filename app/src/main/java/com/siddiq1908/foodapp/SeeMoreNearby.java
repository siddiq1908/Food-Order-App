package com.siddiq1908.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.siddiq1908.foodapp.adapter.NearbyAdapter;
import com.siddiq1908.foodapp.adapter.SeeMoreNearbyAdapter;
import com.siddiq1908.foodapp.adapter.SeeMoreRecommendedAdapter;
import com.siddiq1908.foodapp.model.NearbyModel;
import com.siddiq1908.foodapp.model.SeeMoreNearbyModel;

import java.util.ArrayList;
import java.util.List;

public class SeeMoreNearby extends AppCompatActivity {

    RecyclerView seeMoreNearbyRecycler;
    SeeMoreNearbyAdapter seeMoreNearbyAdapter;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_more_nearby);

        back = findViewById(R.id.back_see_more_nearby);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeeMoreNearby.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        List<SeeMoreNearbyModel> seeMoreNearbyList = new ArrayList<>();
        seeMoreNearbyList.add(new SeeMoreNearbyModel("Restaurant 1", R.drawable.restaurant1, "35 min"));
        seeMoreNearbyList.add(new SeeMoreNearbyModel("Restaurant 2", R.drawable.restaurant2, "26 min"));
        seeMoreNearbyList.add(new SeeMoreNearbyModel("Restaurant 3", R.drawable.restaurant3, "45 min"));
        seeMoreNearbyList.add(new SeeMoreNearbyModel("Restaurant 4", R.drawable.restaurant4, "15 min"));
        seeMoreNearbyList.add(new SeeMoreNearbyModel("Restaurant 5", R.drawable.restaurant5, "28 min"));
        seeMoreNearbyList.add(new SeeMoreNearbyModel("Restaurant 6", R.drawable.restaurant6, "38 min"));

        setSeeMoreNearbyRecycler(seeMoreNearbyList);
    }

    private void setSeeMoreNearbyRecycler(List<SeeMoreNearbyModel> seeMoreNearbyList) {
        seeMoreNearbyRecycler = findViewById(R.id.seeMoreNearbyRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        seeMoreNearbyRecycler.setLayoutManager(layoutManager);
        seeMoreNearbyAdapter = new SeeMoreNearbyAdapter(this, seeMoreNearbyList);
        seeMoreNearbyRecycler.setAdapter(seeMoreNearbyAdapter);
    }
}