package com.example.acer.simplehabit.network.responses;

import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;
import com.example.acer.simplehabit.data.vo.CurrentProgramVO;

import java.util.List;

/**
 * Created by Acer on 5/25/2018.
 */

public class GetCategoryResponse {
    public int code;
    public String message;
    public String apiVersion;
    public String page;
    public List<CategoriesProgramsVO> categoriesPrograms;

    public String getApiVersion() {
        return apiVersion;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getPage() {
        return page;
    }

    public List<CategoriesProgramsVO> getCategoriesPrograms() {
        return categoriesPrograms;
    }
}
