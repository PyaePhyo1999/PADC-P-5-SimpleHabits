package com.example.acer.simplehabit.viewholders;

import android.Manifest;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.adapters.CategoriesAdapter;
import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.delegates.CategoryProgramDelegate;

import org.w3c.dom.Text;

import butterknife.BindView;

/**
 * Created by Acer on 5/26/2018.
 */

public class CategoryViewHolder extends BaseViewHolder<CategoriesProgramsVO> {
    @BindView(R.id.rv_category)
    RecyclerView rvCategory;

    @BindView(R.id.tv_category)
    TextView tvCategory;

    private CategoryProgramDelegate mCategoryProgramDelegate;
    private CategoriesAdapter mCategoryAdapter;

    public CategoryViewHolder(View itemView, CategoryProgramDelegate categoryProgramDelegate) {
        super(itemView);
        mCategoryProgramDelegate = categoryProgramDelegate;
        mCategoryAdapter = new CategoriesAdapter(itemView.getContext(), mCategoryProgramDelegate);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCategory.setLayoutManager(linearLayoutManager);
        rvCategory.setAdapter(mCategoryAdapter);
    }

    @Override
    public void setData(CategoriesProgramsVO data) {
        mCategoryAdapter.setNewData(data.getPrograms());
        tvCategory.setText(data.getTitle());
        mCategoryAdapter.setCategory(data);

    }


    @Override
    public void onClick(View view) {

    }
}
