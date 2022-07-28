package com.siddiq1908.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.siddiq1908.foodapp.adapter.CategoryAdapter;
import com.siddiq1908.foodapp.adapter.CategoryVerAdapter;
import com.siddiq1908.foodapp.adapter.NearbyAdapter;
import com.siddiq1908.foodapp.adapter.RecommendedAdapter;
import com.siddiq1908.foodapp.adapter.VerticalRecyclerUpdater;
import com.siddiq1908.foodapp.model.CategoryModel;
import com.siddiq1908.foodapp.model.CategoryVerModel;
import com.siddiq1908.foodapp.model.NearbyModel;
import com.siddiq1908.foodapp.model.RecommendedModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements VerticalRecyclerUpdater {

    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;
    private String userId;

    private BottomSheetDialog bottomSheetDialog;

    RecyclerView recommendedRecycler, nearbyRecycler, categoryRecycler, categoryVerRecycler;
    RecommendedAdapter recommendedAdapter;
    NearbyAdapter nearbyAdapter;
    CategoryAdapter categoryAdapter;
    CategoryVerAdapter categoryVerAdapter;

    TextView seeMoreCategory, seeMoreRecommended, seeMoreNearby;
    ImageView menu, profile, cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seeMoreCategory = findViewById(R.id.seeMoreCategoryTextView);
        seeMoreRecommended = findViewById(R.id.seeMoreRecommededTextView);
        seeMoreNearby = findViewById(R.id.seeMoreNearbyTextView);

        menu = findViewById(R.id.menuImage);
        profile = findViewById(R.id.profileImage);
        cart = findViewById(R.id.cartImage);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottonSheetTheme);
                View sheetView = LayoutInflater.from(MainActivity.this).inflate(R.layout.bottom_sheet_layout, null);
                sheetView.findViewById(R.id.profileTextView).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, Profile.class);
                        startActivity(intent);
                        bottomSheetDialog.dismiss();
                    }
                });
                sheetView.findViewById(R.id.cartTextView).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, Cart.class);
                        startActivity(intent);
                        bottomSheetDialog.dismiss();
                    }
                });
                sheetView.findViewById(R.id.signOutTextView).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        bottomSheetDialog.dismiss();
                        finish();
                    }
                });
                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("User");
        userId = firebaseUser.getUid();

        final TextView nameText = findViewById(R.id.userName);

        databaseReference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);

                if(user!=null){
                    String nameStr = user.name;

                    nameText.setText(nameStr);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this,"Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cart.class);
                startActivity(intent);
            }
        });

        seeMoreCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SeeMoreCategory.class);
                startActivity(intent);
            }
        });

        seeMoreRecommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SeeMoreRecommended.class);
                startActivity(intent);
            }
        });

        seeMoreNearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SeeMoreNearby.class);
                startActivity(intent);
            }
        });

        ////////CATEGORY HORIZONTAL RECYCLER
        ArrayList<CategoryModel> categoryList = new ArrayList<>();
        categoryList.add(new CategoryModel(R.drawable.pizza,"Pizza"));
        categoryList.add(new CategoryModel(R.drawable.burger,"Burger"));
        categoryList.add(new CategoryModel(R.drawable.biryani,"Biryani"));
        categoryList.add(new CategoryModel(R.drawable.cake,"Cake"));
        categoryList.add(new CategoryModel(R.drawable.ice_cream,"Ice Cream"));
        categoryList.add(new CategoryModel(R.drawable.drink,"Drink"));

        setCategoryRecycler(categoryList);

        ////////CATEGORY ITEM VERTICAL RECYCLER
        ArrayList<CategoryVerModel> categoryVerList = new ArrayList<>();

        setCategoryVerRecycler(categoryVerList);

        ////////RECOMMENDED RECYCLER
        List<RecommendedModel> recommendedList = new ArrayList<>();
        recommendedList.add(new RecommendedModel("Pasta","3.2","30 min","₹49", R.drawable.recommended1,"3.2"));
        recommendedList.add(new RecommendedModel("Biryani","4.2","40 min","₹119", R.drawable.recommended2, "4.2"));
        recommendedList.add(new RecommendedModel("Shawarma","4.5","28 min","₹85", R.drawable.recommended3, "4.5"));
        recommendedList.add(new RecommendedModel("Pasta","3.2","30 min","₹49", R.drawable.recommended1,"3.2"));
        recommendedList.add(new RecommendedModel("Biryani","4.2","40 min","₹119", R.drawable.recommended2, "4.2"));
        recommendedList.add(new RecommendedModel("Shawarma","4.5","28 min","₹85", R.drawable.recommended3,"4.5"));

        setRecommendedRecycler(recommendedList);

        ////////NEARBY RESTAURANT RECYCLER
        List<NearbyModel> nearbyList = new ArrayList<>();
        nearbyList.add(new NearbyModel("Restaurant 1", R.drawable.restaurant1, "35 min"));
        nearbyList.add(new NearbyModel("Restaurant 2", R.drawable.restaurant2, "26 min"));
        nearbyList.add(new NearbyModel("Restaurant 3", R.drawable.restaurant3, "45 min"));
        nearbyList.add(new NearbyModel("Restaurant 4", R.drawable.restaurant4, "15 min"));
        nearbyList.add(new NearbyModel("Restaurant 5", R.drawable.restaurant5, "28 min"));
        nearbyList.add(new NearbyModel("Restaurant 6", R.drawable.restaurant6, "38 min"));

        setNearbyRecycler(nearbyList);

    }

    private void setCategoryRecycler(ArrayList<CategoryModel> categoryList){
        categoryRecycler = findViewById(R.id.category_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
        categoryRecycler.setHasFixedSize(true);
        categoryRecycler.setNestedScrollingEnabled(false);
    }

    private void setCategoryVerRecycler(ArrayList<CategoryVerModel> categoryVerList){
        categoryVerRecycler = findViewById(R.id.category_ver_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        categoryVerRecycler.setLayoutManager(layoutManager);
        categoryVerAdapter = new CategoryVerAdapter(this, categoryVerList);
        categoryVerRecycler.setAdapter(categoryVerAdapter);
    }

    private void setRecommendedRecycler(List<RecommendedModel> recommendedList){
        recommendedRecycler = findViewById(R.id.recommended_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recommendedRecycler.setLayoutManager(layoutManager);
        recommendedAdapter = new RecommendedAdapter(this, recommendedList);
        recommendedRecycler.setAdapter(recommendedAdapter);
    }
    private void setNearbyRecycler(List<NearbyModel> nearbyList){
        nearbyRecycler = findViewById(R.id.nearby_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        nearbyRecycler.setLayoutManager(layoutManager);
        nearbyAdapter = new NearbyAdapter(this, nearbyList);
        nearbyRecycler.setAdapter(nearbyAdapter);
    }

    @Override
    public void callBack(int position, ArrayList<CategoryVerModel> list) {
        categoryVerAdapter = new CategoryVerAdapter(this, list);
        categoryVerAdapter.notifyDataSetChanged();
        categoryVerRecycler.setAdapter(categoryVerAdapter);
    }
}