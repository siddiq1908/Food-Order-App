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
import com.siddiq1908.foodapp.model.PizzaModel;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {
    Context context;
    List<PizzaModel> pizzaList;

    public PizzaAdapter(Context context, List<PizzaModel> pizzaList) {
        this.context = context;
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PizzaAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(pizzaList.get(position).getImageUrl());
        holder.itemName.setText(pizzaList.get(position).getName());
        holder.itemPrice.setText(pizzaList.get(position).getPrice());
        holder.itemRating.setText(pizzaList.get(position).getRating());
        holder.itemRatingBar.setRating(Float.parseFloat(pizzaList.get(position).getRating()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetails.class);
                intent.putExtra("name", pizzaList.get(position).getName());
                intent.putExtra("image", pizzaList.get(position).getImageUrl());
                intent.putExtra("price", pizzaList.get(position).getPrice());
                intent.putExtra("rating", pizzaList.get(position).getRating());
                intent.putExtra("itemRating", pizzaList.get(position).getItemRating());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName, itemPrice, itemRating;
        RatingBar itemRatingBar;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image_category_item);
            itemName = itemView.findViewById(R.id.item_name_category_item);
            itemPrice = itemView.findViewById(R.id.item_price_category_item);
            itemRating = itemView.findViewById(R.id.item_rating_category_item);
            itemRatingBar = itemView.findViewById(R.id.ratingBar_category_item);

        }
    }
}
