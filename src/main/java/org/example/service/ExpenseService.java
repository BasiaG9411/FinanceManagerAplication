package org.example.service;

import org.example.Dao.CategoryDao;
import org.example.Dao.ExpenseDao;
import org.example.entity.Category;
import org.example.entity.Expenses;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseService {

    private ExpenseDao expenseDao = new ExpenseDao();
    private CategoryDao categoryDao = new CategoryDao();


    public void addExpense(BigDecimal ammount, String commentary, LocalDate dateFrom, Category category1) {
        Category category = categoryDao.getByName(category1.getName());
        Expenses expense = new Expenses(null, ammount, dateFrom, commentary, category);
        expenseDao.insert(expense);

    }

    public boolean deleteExpense(Integer id) {
        Expenses expenses = expenseDao.findById(id);
        expenseDao.deleteExpense(expenses);
        return true;
    }

    public List<Expenses> showAllExpenses() {
        return expenseDao.findAll();
    }


}



