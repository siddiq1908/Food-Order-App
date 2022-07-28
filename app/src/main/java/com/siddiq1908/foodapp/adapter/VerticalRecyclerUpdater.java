package com.siddiq1908.foodapp.adapter;

import com.siddiq1908.foodapp.model.CategoryVerModel;

import java.util.ArrayList;

public interface VerticalRecyclerUpdater {
    public void callBack(int position, ArrayList<CategoryVerModel> list);
}
