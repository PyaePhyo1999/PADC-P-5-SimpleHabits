package com.example.acer.simplehabit.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.SimpleHabitApp;
import com.example.acer.simplehabit.adapters.BaseRecyclerAdapter;
import com.example.acer.simplehabit.adapters.SessionsAdapter;
import com.example.acer.simplehabit.data.models.SimpleHabitModel;
import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;
import com.example.acer.simplehabit.data.vo.ProgramVO;
import com.example.acer.simplehabit.delegates.CategoryProgramDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Acer on 5/27/2018.
 */

public class SimpleHabitDetailActivity extends BaseActivity {

    @BindView(R.id.tv_detail_simple_habit_starter)
    TextView tvTitle;

    @BindView(R.id.tv_detail_desc)
    TextView tvDetailDesc;

    @BindView(R.id.rv_sessions)
    RecyclerView rvSessions;
    private SessionsAdapter mSessionsAdapter;
    private CurrentProgramVO currentProgram;
    private ProgramVO program;
    private CategoriesProgramsVO categoriesPrograms;

    public static Intent newIntentCategoryProgram(Context context,String categoryId,String categoryProgramId) {
        Intent intent = new Intent(context, SimpleHabitDetailActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE,SimpleHabitApp.CATEGORY);
        intent.putExtra(SimpleHabitApp.CATEGORY_ID,categoryId);
        intent.putExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID,categoryProgramId);
        return intent;
    }

    public static Intent newIntentCurrentProgram(Context context) {
        Intent intent = new Intent(context, SimpleHabitDetailActivity.class);
        intent.putExtra(SimpleHabitApp.VIEW_TYPE, SimpleHabitApp.CURRENT_PROGRAM);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_activity);
        ButterKnife.bind(this, this);

        mSessionsAdapter = new SessionsAdapter(this);
        String currentProgramId = getIntent().getStringExtra(SimpleHabitApp.PROGRAM_ID);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvSessions.setAdapter(mSessionsAdapter);
        rvSessions.setLayoutManager(linearLayoutManager);


        if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CURRENT_PROGRAM)) {
            CurrentProgramVO currentProgram = SimpleHabitModel.getsObjectInstance().getCurrentProgram();
            mSessionsAdapter.setNewData(currentProgram.getSessions());
            tvTitle.setText(currentProgram.getTitle());
            tvDetailDesc.setText(currentProgram.getDescription());
        } else if (getIntent().getStringExtra(SimpleHabitApp.VIEW_TYPE).equals(SimpleHabitApp.CATEGORY)) {
            String categoryId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_ID);
            String categoryProgramId = getIntent().getStringExtra(SimpleHabitApp.CATEGORY_PROGRAM_ID);

            ProgramVO categoryProgram = SimpleHabitModel.getsObjectInstance().getProgram(categoryId, categoryProgramId);
            mSessionsAdapter.setNewData(categoryProgram.getSessions());
            tvTitle.setText(categoryProgram.getTitle());
            tvDetailDesc.setText(categoryProgram.getDescription());
        }
    }
    @OnClick(R.id.btn_back_press)
    public void onBackPress(View view) {
        onBackPressed();
    }
}

