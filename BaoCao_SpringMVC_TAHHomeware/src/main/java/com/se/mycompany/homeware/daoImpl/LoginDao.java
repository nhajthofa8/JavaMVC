package com.se.mycompany.homeware.daoImpl;

import com.se.mycompany.homeware.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoginDao {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    @Autowired
    private SessionFactory sessionFactory;

    public LoginDao() {
        
    }
    
    @Transactional
    public User checkLogin(String username, String password) {
        try {
            System.err.println("enter");
            Session currentSession = sessionFactory.getCurrentSession();
            Query<User> theQuery = null;
            theQuery = currentSession.createQuery("from User where username = :username and password = :pass", User.class);
            theQuery.setParameter("username",username);
            theQuery.setParameter("pass",password);
            List<User> u = theQuery.getResultList();
            System.err.println("OK");
            if(u != null){
                User user;
                user = new User(u.get(0).getUsername(),u.get(0).getPassword());
                System.err.println(user);
                return user;
            }
           

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
