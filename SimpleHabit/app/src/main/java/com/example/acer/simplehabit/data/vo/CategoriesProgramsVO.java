package com.example.acer.simplehabit.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Acer on 5/25/2018.
 */

public class CategoriesProgramsVO implements HomeScreenVO {
    @SerializedName("category-id")
    public String categoryId;
    public String title;
    public List<ProgramVO> programs;

    public String getTitle() {
        return title;
    }

    public List<ProgramVO> getPrograms() {
        return programs;
    }

    public String getCategoryId() {
        return categoryId;
    }
}
