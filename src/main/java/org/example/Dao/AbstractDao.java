package org.example.Dao;

import org.example.Connection;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractDao<T> {

    private Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }
    public void insert(T t) {
        Session session = Connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }


}
