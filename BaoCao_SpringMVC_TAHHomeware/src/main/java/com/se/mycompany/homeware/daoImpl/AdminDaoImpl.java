package com.se.mycompany.homeware.daoImpl;

import com.se.mycompany.homeware.dao.AdminDao;
import com.se.mycompany.homeware.model.Admin;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(Admin admin) {
       Session currentSession = sessionFactory.getCurrentSession();
        System.err.println("ok");
        currentSession.save(admin);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Admin tempAdmin = currentSession.get(Admin.class, Integer.parseInt(id));
        currentSession.delete(tempAdmin);
    }

    @Override
    @Transactional
    public Admin get(int id) {
         Session currentSession = sessionFactory.getCurrentSession();
        Admin admin = currentSession.get(Admin.class, id);

        if (admin == null) {
            System.err.println("Loiii");
        } else {
            System.err.println("ok");
        }
        return admin;
    }

    @Override
    @Transactional
    public void edit(Admin admin) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(admin);
    }

    @Override
    public Admin get(String name) {
        return null;
    }

    @Override
    @Transactional
    public List<Admin> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Admin> theQuery = currentSession.createQuery("from Admin", Admin.class);
        List<Admin> admins = theQuery.getResultList();
        return admins;
    }

}
