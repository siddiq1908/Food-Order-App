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
import com.siddiq1908.foodapp.model.CategoryVerModel;

import java.util.ArrayList;

public class CategoryVerAdapter extends RecyclerView.Adapter<CategoryVerAdapter.ViewHolder> {

    Context context;
    ArrayList<CategoryVerModel> categoryVerList;

    public CategoryVerAdapter(Context context, ArrayList<CategoryVerModel> categoryVerList) {
        this.context = context;
        this.categoryVerList = categoryVerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_vertical_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(categoryVerList.get(position).getImageUrl());
        holder.itemName.setText(categoryVerList.get(position).getName());
        holder.itemPrice.setText(categoryVerList.get(position).getPrice());
        holder.itemRating.setText(categoryVerList.get(position).getRating());
        holder.itemRatingBar.setRating(Float.parseFloat(categoryVerList.get(position).getRating()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetails.class);
                intent.putExtra("name", categoryVerList.get(position).getName());
                intent.putExtra("image", categoryVerList.get(position).getImageUrl());
                intent.putExtra("price", categoryVerList.get(position).getPrice());
                intent.putExtra("rating", categoryVerList.get(position).getRating());
                intent.putExtra("itemRating", categoryVerList.get(position).getItemRating());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryVerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName, itemRating, itemPrice;
        RatingBar itemRatingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image_category_ver);
            itemName = itemView.findViewById(R.id.item_name_category_ver);
            itemPrice = itemView.findViewById(R.id.item_price_category_ver);
            itemRating = itemView.findViewById(R.id.item_rating_category_ver);
            itemRatingBar = itemView.findViewById(R.id.ratingBar_category_ver);
        }
    }
}
