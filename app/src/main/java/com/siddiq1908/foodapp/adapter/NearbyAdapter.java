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
import com.siddiq1908.foodapp.model.NearbyModel;

import java.util.List;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyViewHolder> {
    Context context;
    List<NearbyModel> nearbyList;

    public NearbyAdapter(Context context, List<NearbyModel> nearbyList) {
        this.context = context;
        this.nearbyList = nearbyList;
    }

    @NonNull
    @Override
    public NearbyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NearbyViewHolder(LayoutInflater.from(context).inflate(R.layout.nearby_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyViewHolder holder, int position) {
        holder.itemImage.setImageResource(nearbyList.get(position).getImageUrl());
        holder.itemName.setText(nearbyList.get(position).getName());
        holder.itemTime.setText(nearbyList.get(position).getTime());

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
        return nearbyList.size();
    }

    public static final class NearbyViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemTime, itemName;

        public NearbyViewHolder(@NonNull View itemView){
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image_nearby);
            itemTime = itemView.findViewById(R.id.item_time_nearby);
            itemName = itemView.findViewById(R.id.item_name_nearby);
        }
    }
}
