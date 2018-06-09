package com.example.acer.simplehabit.events;

import com.example.acer.simplehabit.data.vo.CategoriesProgramsVO;

import java.util.List;

/**
 * Created by Acer on 5/26/2018.
 */

public class CategoryProgramEvent {
    private List<CategoriesProgramsVO> loadCategory;

    public List<CategoriesProgramsVO> getLoadCategory() {
        return loadCategory;
    }
    public CategoryProgramEvent(List<CategoriesProgramsVO> categoriesPrograms)
    {
        loadCategory=categoriesPrograms;
    }
}
