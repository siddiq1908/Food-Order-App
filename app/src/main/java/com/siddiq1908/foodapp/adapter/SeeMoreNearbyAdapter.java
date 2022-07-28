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

import com.siddiq1908.foodapp.ItemDetails;
import com.siddiq1908.foodapp.R;
import com.siddiq1908.foodapp.model.SeeMoreNearbyModel;

import java.util.List;

public class SeeMoreNearbyAdapter extends RecyclerView.Adapter<SeeMoreNearbyAdapter.ViewHolder> {
    Context context;
    List<SeeMoreNearbyModel> seeMoreNearbyList;

    public SeeMoreNearbyAdapter(Context context, List<SeeMoreNearbyModel> seeMoreNearbyList) {
        this.context = context;
        this.seeMoreNearbyList = seeMoreNearbyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.see_more_nearby_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(seeMoreNearbyList.get(position).getImageUrl());
        holder.itemName.setText(seeMoreNearbyList.get(position).getName());
        holder.itemTime.setText(seeMoreNearbyList.get(position).getTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetails.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return seeMoreNearbyList.size();
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemTime, itemName;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image_see_more_nearby);
            itemTime = itemView.findViewById(R.id.item_time_see_more_nearby);
            itemName = itemView.findViewById(R.id.item_name_see_more_nearby);
        }
    }
}
