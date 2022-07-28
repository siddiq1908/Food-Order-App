package com.siddiq1908.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class ItemDetails extends AppCompatActivity {

    int numberOrder = 1;

    ImageView itemImage, back, plus, minus;
    TextView titleTxt, feeTxt, itemRating, numberOrderTxt;
    RatingBar itemRatingBar;
    Button addToCart;

    String name, price, rating, ratingBar;
    Integer image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        rating = intent.getStringExtra("rating");
        image = intent.getIntExtra("image", R.drawable.cheese_pizza);
        ratingBar = intent.getStringExtra("itemRating");

        titleTxt = findViewById(R.id.item_name_item_details);
        feeTxt = findViewById(R.id.item_price_item_details);
        itemRating = findViewById(R.id.item_rating_item_details);
        itemRatingBar = findViewById(R.id.ratingBar_item_details);
        itemImage = findViewById(R.id.item_image_item_details);
        numberOrderTxt = findViewById(R.id.quantityTextView);
        back = findViewById(R.id.back_item_details);
        plus = findViewById(R.id.plusImage);
        minus = findViewById(R.id.minusImage);
        addToCart = findViewById(R.id.addToCartButton_itemDetails);


        itemImage.setImageResource(image);
        titleTxt.setText(name);
        feeTxt.setText(price);
        itemRating.setText(rating);
        itemRatingBar.setRating(Float.parseFloat(ratingBar));

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder <10) {
                    numberOrder +=1;
                    numberOrderTxt.setText(String.valueOf(numberOrder));
                }else{
                    Toast.makeText(ItemDetails.this, "Maximum item limit is 10", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder >1) {
                    numberOrder -=1;
                    numberOrderTxt.setText(String.valueOf(numberOrder));
                }else{
                    Toast.makeText(ItemDetails.this, "Minimum 1 item required", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ItemDetails.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}