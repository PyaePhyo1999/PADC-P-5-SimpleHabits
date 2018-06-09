package com.example.acer.simplehabit.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.data.vo.ProgramVO;
import com.example.acer.simplehabit.delegates.CategoryProgramDelegate;
import com.example.acer.simplehabit.viewholders.BaseViewHolder;
import com.example.acer.simplehabit.viewholders.ItemCategoriesViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 5/18/2018.
 */

public class CategoriesAdapter extends BaseRecyclerAdapter<ItemCategoriesViewHolder, ProgramVO> {
    private CategoriesProgramsVO mRootCategory;
    private CategoryProgramDelegate mCategoryProgramDelegate;

    public CategoriesAdapter(Context context, CategoryProgramDelegate categoryProgramDelegate) {
        super(context);
        mCategoryProgramDelegate = categoryProgramDelegate;
    }

    @NonNull
    @Override
    public ItemCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.item_category, parent, false);
        return new ItemCategoriesViewHolder(view, mCategoryProgramDelegate);
    }

    @Override
    public void onBindViewHolder(ItemCategoriesViewHolder holder, int position) {
        holder.setData(mData.get(position));
        holder.setCategory(mRootCategory);
    }

    public void setCategory(CategoriesProgramsVO category) {
        mRootCategory = category;
    }

//    @Override
//    public int getItemCount() {
//        return mCategoriesProgram.size();
//    }
}
