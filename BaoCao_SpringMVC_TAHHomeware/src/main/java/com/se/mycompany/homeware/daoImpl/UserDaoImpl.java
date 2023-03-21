package com.se.mycompany.homeware.daoImpl;

import com.se.mycompany.homeware.dao.UserDao;
import com.se.mycompany.homeware.model.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User tempUser = currentSession.get(User.class, id);
        currentSession.delete(tempUser);
    }

    @Override
    @Transactional
    public User get(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public User get(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);

        return user;
    }

    @Override
    @Transactional
    public void edit(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);

    }

    @Override
    @Transactional
    public List<User> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = currentSession.createQuery("from User", User.class);
        List<User> users = theQuery.getResultList();
        return users;
    }

}
