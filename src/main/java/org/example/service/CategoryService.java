package org.example.service;

import org.example.Dao.CategoryDao;
import org.example.entity.Category;


public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();

    public boolean addNewCategory(String categoryName) {
        if (!categoryDao.existsByName(categoryName)) {
            Category category = new Category(null, categoryName);
            categoryDao.insert(category);
        }
        return false;
    }


    public boolean deleteCategory(String categoryName) {
            Category category = categoryDao.getByName(categoryName);
            categoryDao.deleteCategory(category);
            return true;
    }
}




