package com.siddiq1908.foodapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.siddiq1908.foodapp.MainActivity;
import com.siddiq1908.foodapp.R;
import com.siddiq1908.foodapp.model.CategoryModel;
import com.siddiq1908.foodapp.model.CategoryVerModel;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    VerticalRecyclerUpdater verticalRecyclerUpdater;
    Activity activity;
    ArrayList<CategoryModel> categoryList;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public CategoryAdapter(VerticalRecyclerUpdater verticalRecyclerUpdater, Activity activity, ArrayList<CategoryModel> categoryList) {
        this.verticalRecyclerUpdater = verticalRecyclerUpdater;
        this.activity = activity;
        this.categoryList = categoryList;
    }

    public CategoryAdapter(MainActivity verticalRecyclerUpdater, ArrayList<CategoryModel> categoryList) {
        this.verticalRecyclerUpdater = verticalRecyclerUpdater;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemImage.setImageResource(categoryList.get(position).getImageUrl());
        holder.itemName.setText(categoryList.get(position).getName());

        if(check) {
            ArrayList<CategoryVerModel> categoryVerModels = new ArrayList<>();
            categoryVerModels.add(new CategoryVerModel(R.drawable.cheese_pizza,"Cheese Pizza","4.5","₹129","4.5"));
            categoryVerModels.add(new CategoryVerModel(R.drawable.margherita_pizza,"Margherita Pizza","4.1","₹149","4.1"));
            categoryVerModels.add(new CategoryVerModel(R.drawable.chicken_barbecue_pizza,"Chicken Barbecue Pizza","4.4","₹239","4.4"));
            categoryVerModels.add(new CategoryVerModel(R.drawable.veg_loaded_pizza,"Veg Loaded Pizza","4.0","₹109","4.0"));
            categoryVerModels.add(new CategoryVerModel(R.drawable.golden_corn_pizza,"Golden Corn Pizza","4.3","₹119","4.3"));
            verticalRecyclerUpdater.callBack(position, categoryVerModels);
            check = false;
        }

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index = position;
                    notifyDataSetChanged();

                    if (position == 0){
                        ArrayList<CategoryVerModel> categoryVerModels = new ArrayList<>();
                        categoryVerModels.add(new CategoryVerModel(R.drawable.cheese_pizza,"Cheese Pizza","4.5","₹129","4.5"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.margherita_pizza,"Margherita Pizza","4.1","₹149","4.1"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.chicken_barbecue_pizza,"Chicken Barbecue Pizza","4.4","₹239","4.4"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.veg_loaded_pizza,"Veg Loaded Pizza","4.0","₹109","4.0"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.golden_corn_pizza,"Golden Corn Pizza","4.3","₹119","4.3"));

                        verticalRecyclerUpdater.callBack(position, categoryVerModels);
                    }
                    else if (position == 1){
                        ArrayList<CategoryVerModel> categoryVerModels = new ArrayList<>();
                        categoryVerModels.add(new CategoryVerModel(R.drawable.chicken_burger,"Chicken Burger","4.5","₹89","4.5"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.veg_burger,"Veg Burger","4.2","₹59","4.2"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.cheese_burger,"Cheese Burger","4.4","₹79","4.4"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.aloo_burger,"Aloo Burger","4.0","₹49","4.0"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.egg_burger,"Egg Burger","4.1","₹75","4.1"));

                        verticalRecyclerUpdater.callBack(position, categoryVerModels);
                    }
                    else if (position == 2){
                        ArrayList<CategoryVerModel> categoryVerModels = new ArrayList<>();
                        categoryVerModels.add(new CategoryVerModel(R.drawable.mutton_biryani,"Mutton Biryani","4.5","₹129","4.5"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.chicken_biryani,"Chicken Biryani","4.5","₹129","4.5"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.hyderabad_biryani,"Hyderabadi Biryani","4.5","₹129","4.5"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.moradabad_biryani,"Moradabadi Biryani","4.5","₹129","4.5"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.veg_biryani,"Veg Biryani","4.5","₹129","4.5"));

                        verticalRecyclerUpdater.callBack(position, categoryVerModels);
                    }
                    else if (position == 3){
                        ArrayList<CategoryVerModel> categoryVerModels = new ArrayList<>();
                        categoryVerModels.add(new CategoryVerModel(R.drawable.chocolate_cake,"Chocolate Cake","4.5","₹499","4.5"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.vanilla_cake,"Vanilla Cake","4.8","₹449","4.8"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.red_velvet_cake,"Red Velvet Cake","4.4","₹549","4.4"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.pineapple_cake,"Pineapple Cake","4.2","₹399","4.2"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.butterscotch_cake,"Butterscotch Cake","4.3","₹429","4.3"));

                        verticalRecyclerUpdater.callBack(position, categoryVerModels);
                    }
                    else if (position == 4){
                        ArrayList<CategoryVerModel> categoryVerModels = new ArrayList<>();
                        categoryVerModels.add(new CategoryVerModel(R.drawable.chocolate_icecream,"Chocolate Ice-cream","4.5","₹199","4.5"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.strawberry_icecream,"Strawberry Ice-cream","4.8","₹149","4.8"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.mango_icecream,"Mango Ice-cream","4.4","₹249","4.4"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.kulfi,"Kulfi","4.2","₹50","4.2"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.cornetto,"Cornetto","4.3","₹60","4.3"));

                        verticalRecyclerUpdater.callBack(position, categoryVerModels);
                    }
                    else if (position == 5){
                        ArrayList<CategoryVerModel> categoryVerModels = new ArrayList<>();
                        categoryVerModels.add(new CategoryVerModel(R.drawable.coke,"Coke","4.5","₹40","4.5"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.cold_coffee,"Cold Coffee","4.3","₹60","4.3"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.ice_tea,"Ice Tea","4.4","₹60","4.4"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.lemonade,"Lemonade","4.1","₹30","4.1"));
                        categoryVerModels.add(new CategoryVerModel(R.drawable.orange_juice,"Orange Juice","4.0","₹50","4.0"));

                        verticalRecyclerUpdater.callBack(position, categoryVerModels);
                    }
                }
            });

            if(select){
                if(position == 0){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select = false;
                }
            }
            else{
                if(row_index == position){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }
                else{
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }
        }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemName;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image_category_hor);
            itemName = itemView.findViewById(R.id.item_name_category_hor);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
