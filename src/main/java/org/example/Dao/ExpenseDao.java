package org.example.Dao;

import org.example.Connection;
import org.example.entity.Category;
import org.example.entity.Expenses;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;


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

    //    public List<Expenses>  sumOfExpensesByCategory(Integer category_id) {
//        String hql = "sum(ammount) FROM Expenses Group by category_id = :p1";
//        Session session = Connection.getSession();
//        Query<Expenses> query = session.createQuery(hql, Expenses.class);
//        query.setParameter("p1", category_id);
//
//        List<Expenses> resultList = query.getResultList();
//
//        session.close();
//
//        return resultList;
//
//    }
    public List<Expenses> showAllExpensesByCategory(Integer id) {
        String hql = "FROM Expenses e WHERE e.category.id = :p1";
        Session session = Connection.getSession();
        Query<Expenses> query = session.createQuery(hql, Expenses.class);
        query.setParameter("p1", id);

        List<Expenses> expenses = query.getResultList();

        session.close();

        return expenses;

    }

    public BigDecimal saldo() {
        String hql = "SELECT (sum(e.amount) - (SELECT sum(e.amount) FROM Income e)) FROM Expenses e";
        Session session = Connection.getSession();
        Query<BigDecimal> query = session.createQuery(hql, BigDecimal.class);


        BigDecimal expenses = query.uniqueResult();
        session.close();

        return expenses;

    }


}






