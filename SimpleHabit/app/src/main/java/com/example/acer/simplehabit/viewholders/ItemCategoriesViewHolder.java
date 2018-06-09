package com.example.acer.simplehabit.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.ProgramVO;
import com.example.acer.simplehabit.delegates.CategoryProgramDelegate;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Acer on 5/18/2018.
 */

public class ItemCategoriesViewHolder extends BaseViewHolder<ProgramVO> {
    @BindView(R.id.tv_category_name)
    TextView tvCategory;

    @BindView(R.id.tv_category_time)
    TextView tvCategoryTime;

    private CategoriesProgramsVO mCategoryProgram;
    private ProgramVO mProgram;
    private CategoryProgramDelegate mCategoryProgramDelegate;

    public ItemCategoriesViewHolder(View itemView, CategoryProgramDelegate categoryProgramDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mCategoryProgramDelegate = categoryProgramDelegate;
    }

    @Override
    public void setData(ProgramVO data) {
        mProgram = data;
        tvCategory.setText(data.getTitle());


    }

    public void setCategory(CategoriesProgramsVO category) {
        mCategoryProgram = category;
    }


    @Override
    public void onClick(View view) {
        mCategoryProgramDelegate.onTapCategoryDelegate(mCategoryProgram.getCategoryId(), mProgram.getProgramId());
    }
}
