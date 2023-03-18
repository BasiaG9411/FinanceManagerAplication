package org.example.Dao;

import org.example.entity.Expense;

public class ExpenseDao extends AbstractDao<Expense> {

    public ExpenseDao() {
        super(Expense.class);
    }
}
