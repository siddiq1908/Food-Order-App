package com.siddiq1908.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siddiq1908.foodapp.ItemDetails;
import com.siddiq1908.foodapp.R;
import com.siddiq1908.foodapp.model.SeeMoreRecommendedModel;

import java.util.ArrayList;

public class SeeMoreRecommendedAdapter extends RecyclerView.Adapter<SeeMoreRecommendedAdapter.ViewHolder> {

    Context context;
    ArrayList<SeeMoreRecommendedModel> seeMoreRecommendedList;

    public SeeMoreRecommendedAdapter(Context context, ArrayList<SeeMoreRecommendedModel> seeMoreRecommendedList) {
        this.context = context;
        this.seeMoreRecommendedList = seeMoreRecommendedList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.see_more_recommended_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(seeMoreRecommendedList.get(position).getImageUrl());
        holder.itemName.setText(seeMoreRecommendedList.get(position).getName());
        holder.itemPrice.setText(seeMoreRecommendedList.get(position).getPrice());
        holder.itemRating.setText(seeMoreRecommendedList.get(position).getRating());
        holder.itemRatingBar.setRating(Float.parseFloat(seeMoreRecommendedList.get(position).getRating()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetails.class);
                intent.putExtra("name", seeMoreRecommendedList.get(position).getName());
                intent.putExtra("image", seeMoreRecommendedList.get(position).getImageUrl());
                intent.putExtra("price", seeMoreRecommendedList.get(position).getPrice());
                intent.putExtra("rating", seeMoreRecommendedList.get(position).getRating());
                intent.putExtra("itemRating", seeMoreRecommendedList.get(position).getItemRating());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return seeMoreRecommendedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName, itemRating, itemPrice;
        RatingBar itemRatingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image_see_more_recommended);
            itemName = itemView.findViewById(R.id.item_name_see_more_recommended);
            itemPrice = itemView.findViewById(R.id.item_price_see_more_recommended);
            itemRating = itemView.findViewById(R.id.item_rating_see_more_recommended);
            itemRatingBar = itemView.findViewById(R.id.ratingBar_see_more_recommended);
        }
    }
}
