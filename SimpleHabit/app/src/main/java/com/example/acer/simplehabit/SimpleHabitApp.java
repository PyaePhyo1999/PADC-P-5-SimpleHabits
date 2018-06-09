package com.example.acer.simplehabit;

import android.app.Application;

import com.example.acer.simplehabit.data.models.SimpleHabitModel;

/**
 * Created by Acer on 5/26/2018.
 */

public class SimpleHabitApp extends Application {
    public static final String LOG_TAG = "Simple Habit";
    public static final String PROGRAM_ID="ProgramId";
    public static final String VIEW_TYPE="viewType";
    public static final String CURRENT_PROGRAM="currentId";
    public static final String CATEGORY="category";
    public static final String CATEGORY_ID="categoryId";
    public static final String CATEGORY_PROGRAM_ID="categoryProgramId";




    @Override
    public void onCreate() {
        super.onCreate();
    }
}
