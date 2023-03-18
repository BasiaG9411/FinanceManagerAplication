package org.example.Dao;

import org.example.Connection;
import org.example.entity.Category;
import org.example.entity.Expenses;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;


public class ExpenseDao extends AbstractDao<Expenses> {

    public ExpenseDao() {
        super(Expenses.class);
    }

    public static Expenses findById(Integer id) {
        String hql = "FROM Expenses WHERE id = :p1";
        Session session = Connection.getSession();
        Query<Expenses> query = session.createQuery(hql, Expenses.class);
        query.setParameter("p1", id);

        Expenses expenses = query.uniqueResult();
        session.close();

        return expenses;

    }

    public void deleteExpense(Expenses expenses) {
        delete(expenses);
    }

    public List<Expenses> findAll() {
        String hql = "FROM Expenses";
        Session session = Connection.getSession();
        Query<Expenses> query = session.createQuery(hql, Expenses.class);

        List<Expenses> resultList = query.getResultList();

        session.close();

        return resultList;

    }
}






