package org.example.Dao;

import org.example.Connection;
import org.example.entity.Income;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;



public class IncomeDao extends AbstractDao<Income> {

    public IncomeDao() {
        super(Income.class);
    }

    public static Income findById(Integer id) {
        String hql = "FROM Income WHERE id = :p1";
        Session session = Connection.getSession();
        Query<Income> query = session.createQuery(hql, Income.class);
        query.setParameter("p1", id);
        Income income = query.uniqueResult();
        session.close();

        return income;

    }

    public void deleteIncome(Income income) {
        delete(income);
    }

    public List<Income> findAllIncomes() {
        String hql = "FROM Income";
        Session session = Connection.getSession();
        Query<Income> query = session.createQuery(hql, Income.class);

        List<Income> resultList = query.getResultList();

        session.close();

        return resultList;

    }
}






