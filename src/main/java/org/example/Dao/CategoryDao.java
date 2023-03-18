package org.example.Dao;


import org.example.Connection;
import org.example.entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;



public class CategoryDao extends AbstractDao<Category> {

    public CategoryDao() {
        super(Category.class);
    }

    public static Category getByName(String categoryName) {
        String hql = "FROM Category WHERE name = :p1";
        Session session = Connection.getSession();
        Query<Category> query = session.createQuery(hql, Category.class);
        query.setParameter("p1", categoryName);

        Category category = query.uniqueResult();
        session.close();

        return  category;

    }

    public boolean existsByName(String categoryName) {
        return getByName(categoryName) == null ? false : true;
    }
}


