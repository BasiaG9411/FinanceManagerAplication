package org.example.Dao;

import org.example.entity.Expenses;

public class ExpenseDao extends AbstractDao<Expenses> {

    public ExpenseDao() {
        super(Expenses.class);
    }
}
