package org.example.service;

import org.example.Dao.CategoryDao;
import org.example.Dao.ExpenseDao;
import org.example.entity.Category;
import org.example.entity.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class ExpenseService {

    private ExpenseDao expenseDao = new ExpenseDao();
    private CategoryDao categoryDao = new CategoryDao();


    public void addExpense(BigDecimal ammount, String commentary, LocalDate dateFrom, Category category1) {
        Category category = categoryDao.getByName(category1.getName());
        Expense expense = new Expense(null, ammount, dateFrom, commentary, category);
        expenseDao.insert(expense);

    }


}
