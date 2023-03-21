package com.se.mycompany.homeware.daoImpl;

import com.se.mycompany.homeware.dao.ProductDao;
import com.se.mycompany.homeware.model.Product;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(Product product) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(product);
    }

    @Override
    @Transactional
    public void edit(Product product) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(product);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product tempProduct = currentSession.get(Product.class, Integer.parseInt(id));
        currentSession.delete(tempProduct);
    }

    @Override
    @Transactional
    public Product get(String name) {
        return null;
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);
        List<Product> products = theQuery.getResultList();
        return products;

    }

    @Override
    @Transactional
    public List<Product> getProductById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Product> products;
        Query<Product> theQuery = currentSession.createQuery("from Product where catalog_id= :id", Product.class);
        theQuery.setParameter("id", id);
        products = theQuery.getResultList();
        return products;
    }

    @Override
    public List<Product> searchByName(String keyword) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Product> products;
        Query<Product> theQuery = currentSession.createQuery("from Product where name like :name", Product.class);
        theQuery.setParameter("name", "%" + keyword + "%");
        products = theQuery.getResultList();
        return products;
    }

    @Override
    @Transactional
    public Product get(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Product product = currentSession.get(Product.class, id);

        if (product == null) {
            System.err.println("Loiii");
        } else {
            System.err.println("ok");
        }
        return product;
    }
}
