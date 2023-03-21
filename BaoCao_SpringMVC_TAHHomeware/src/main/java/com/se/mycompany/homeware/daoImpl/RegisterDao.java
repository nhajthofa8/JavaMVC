package com.se.mycompany.homeware.daoImpl;

import com.se.mycompany.homeware.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RegisterDao {

    @Autowired
    private SessionFactory sessionFactory;

    public RegisterDao() {
    }

    @Transactional
    public boolean RegisterUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
        return true;
    }

//    public boolean RegisterUser(User user) {
//        boolean set = false;
//        try {
//            String sql = "INSERT INTO users (username,password,email,phone,name,created) values (?,?,?,?,?,?)";
//            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getEmail());
//            preparedStatement.setString(4, user.getPhone());
//            preparedStatement.setString(5, user.getName());
//            preparedStatement.setDate(6, user.getCreated());
//            preparedStatement.executeUpdate();
//
//            set = true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return set;  // On failure, send a message from here.
//    }
}
