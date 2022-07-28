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
import com.siddiq1908.foodapp.model.RecommendedModel;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder> {
    Context context;
    List<RecommendedModel> recommendedList;

    public RecommendedAdapter(Context context, List<RecommendedModel> recommendedList) {
        this.context = context;
        this.recommendedList = recommendedList;
    }

    @NonNull
    @Override
    public RecommendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecommendedViewHolder(LayoutInflater.from(context).inflate(R.layout.recommended_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedViewHolder holder, int position) {
        holder.itemImage.setImageResource(recommendedList.get(position).getImageUrl());
        holder.itemName.setText(recommendedList.get(position).getName());
        holder.itemTime.setText(recommendedList.get(position).getTime());
        holder.itemPrice.setText(recommendedList.get(position).getPrice());
        holder.itemRatingBar.setRating(Float.parseFloat(recommendedList.get(position).getRating()));
        holder.itemRating.setText(recommendedList.get(position).getItemrating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetails.class);
                intent.putExtra("name", recommendedList.get(position).getName());
                intent.putExtra("image", recommendedList.get(position).getImageUrl());
                intent.putExtra("price", recommendedList.get(position).getPrice());
                intent.putExtra("rating", recommendedList.get(position).getRating());
                intent.putExtra("itemRating", recommendedList.get(position).getItemrating());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recommendedList.size();
    }

    public static final class RecommendedViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemPrice, itemTime, itemName, itemRating;
        RatingBar itemRatingBar;

        public RecommendedViewHolder(@NonNull View itemView){
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image_recommended);
            itemPrice = itemView.findViewById(R.id.item_price_recommended);
            itemTime = itemView.findViewById(R.id.item_time_recommended);
            itemName = itemView.findViewById(R.id.item_name_recommended);
            itemRatingBar = itemView.findViewById(R.id.ratingbar_recommended);
            itemRating = itemView.findViewById(R.id.item_rating_recommended);
        }
    }
}
