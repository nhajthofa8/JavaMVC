package com.se.mycompany.homeware.daoImpl;

import com.se.mycompany.homeware.dao.BoardnewDao;
import com.se.mycompany.homeware.model.Boardnew;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.vienmv.dao.impl.String;
//import com.vienmv.model.Category;
@Repository
public class BoardnewDaoImpl implements BoardnewDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(Boardnew boardnew) {
        Session currentSession = sessionFactory.getCurrentSession();
        System.err.println("ok");
        currentSession.save(boardnew);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Boardnew tempBoardnew = currentSession.get(Boardnew.class, id);
        currentSession.delete(tempBoardnew);
    }

    @Override
    @Transactional
    public void edit(Boardnew boardnew) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(boardnew);
    }

    @Override
    @Transactional
    public Boardnew get(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Boardnew boardnew = currentSession.get(Boardnew.class, id);

        if (boardnew == null) {
            System.err.println("Loiii");
        } else {
            System.err.println("ok");
        }
        return boardnew;
    }

    @Override
    public Boardnew get(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public List<Boardnew> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Boardnew> theQuery = currentSession.createQuery("from Boardnew", Boardnew.class);
        List<Boardnew> boardnews = theQuery.getResultList();
        return boardnews;
    }

}
