package com.se.mycompany.homeware.daoImpl;

import com.se.mycompany.homeware.dao.CategoryDao;
import com.se.mycompany.homeware.model.Catalog;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(Catalog category) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(category);
    }

    @Override
    @Transactional
    public void edit(Catalog category) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(category);

    }

    @Override
    @Transactional
    public Catalog get(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Catalog category = currentSession.get(Catalog.class, id);
        return category;

    }

    @Override
    @Transactional
    public Catalog get(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public List<Catalog> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Catalog> theQuery = currentSession.createQuery("from Catalog", Catalog.class);
        List<Catalog> categories = theQuery.getResultList();
        return categories;
    }

    @Override
    @Transactional
    public void delete(String id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Catalog tempCatalog = currentSession.get(Catalog.class, Integer.parseInt(id));
        currentSession.delete(tempCatalog);
    }


    @Override
    public List<Catalog> getCateByProduct(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
