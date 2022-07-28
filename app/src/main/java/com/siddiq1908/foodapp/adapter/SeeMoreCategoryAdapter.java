package com.siddiq1908.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siddiq1908.foodapp.Biryani;
import com.siddiq1908.foodapp.Burger;
import com.siddiq1908.foodapp.Cake;
import com.siddiq1908.foodapp.Drink;
import com.siddiq1908.foodapp.IceCream;
import com.siddiq1908.foodapp.Pizza;
import com.siddiq1908.foodapp.R;
import com.siddiq1908.foodapp.model.SeeMoreCategoryModel;

import java.util.List;

public class SeeMoreCategoryAdapter extends RecyclerView.Adapter<SeeMoreCategoryAdapter.ViewHolder> {
    Context context;
    List<SeeMoreCategoryModel> seeMoreCategoryList;

    public SeeMoreCategoryAdapter(Context context, List<SeeMoreCategoryModel> seeMoreCategoryList) {
        this.context = context;
        this.seeMoreCategoryList = seeMoreCategoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.see_more_category_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(seeMoreCategoryList.get(position).getImageUrl());
        holder.itemName.setText(seeMoreCategoryList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0){
                    Intent intent = new Intent(context, Pizza.class);
                    context.startActivity(intent);
                } else if(position == 1){
                    Intent intent = new Intent(context, Burger.class);
                    context.startActivity(intent);
                }else if(position == 2){
                    Intent intent = new Intent(context, Biryani.class);
                    context.startActivity(intent);
                }else if(position == 3){
                    Intent intent = new Intent(context, Cake.class);
                    context.startActivity(intent);
                }else if(position == 4){
                    Intent intent = new Intent(context, IceCream.class);
                    context.startActivity(intent);
                }else if(position == 5){
                    Intent intent = new Intent(context, Drink.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return seeMoreCategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image_see_more_category);
            itemName = itemView.findViewById(R.id.item_name_see_more_category);
        }
    }
}
