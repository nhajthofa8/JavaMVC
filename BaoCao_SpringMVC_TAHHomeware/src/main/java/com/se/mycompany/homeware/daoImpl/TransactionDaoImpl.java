package com.se.mycompany.homeware.daoImpl;

import com.se.mycompany.homeware.dao.TransactionDao;
import com.se.mycompany.homeware.model.Transactions;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(Transactions transaction) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(transaction);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Transactions tempTransaction = currentSession.get(Transactions.class, Integer.parseInt(id));
        currentSession.delete(tempTransaction);
    }

    @Override
    @Transactional
    public Transactions get(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Transactions transaction = currentSession.get(Transactions.class, id);
        return transaction;
    }

    @Override
    @Transactional
    public void edit(Transactions transaction) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(transaction);
    }

    @Override
    public Transactions get(String name) {
        return null;
    }

    @Override
    @Transactional
    public List<Transactions> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Transactions> theQuery = currentSession.createQuery("from Transactions", Transactions.class);
        List<Transactions> transactions = theQuery.getResultList();
        return transactions;
    }
}
