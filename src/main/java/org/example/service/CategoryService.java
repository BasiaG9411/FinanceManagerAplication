package org.example.service;

import org.example.Dao.CategoryDao;
import org.example.entity.Category;
import org.example.entity.Expense;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();

    public boolean addNewCategory(String categoryName) {
        if (!categoryDao.existsByName(categoryName)) {
            Category category = new Category(null, categoryName);
            categoryDao.insert(category);
        }
        return false;
    }
}




