package com.se.mycompany.homeware.serviceImpl;

import com.se.mycompany.homeware.dao.TransactionDao;
import com.se.mycompany.homeware.daoImpl.TransactionDaoImpl;
import com.se.mycompany.homeware.model.Transactions;
import com.se.mycompany.homeware.service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServicesImpl implements TransactionService {

    @Autowired
    TransactionDao transactionDao = new TransactionDaoImpl();

    @Override
    public void insert(Transactions transaction) {
        transactionDao.insert(transaction);
    }

    @Override
    public void edit(Transactions transaction) {
        Transactions oldTransaction = transactionDao.get(transaction.getId());
        oldTransaction.setUser_name(transaction.getUser_name());
        oldTransaction.setUser_mail(transaction.getUser_mail());
        oldTransaction.setUser_phone(transaction.getUser_phone());
        oldTransaction.setAddress(transaction.getAddress());
        oldTransaction.setMessage(transaction.getMessage());
        oldTransaction.setAmount(transaction.getAmount());
        oldTransaction.setPayment(transaction.getPayment());
        oldTransaction.setStatus(transaction.getStatus());
        transactionDao.edit(oldTransaction);
    }

    @Override
    public void delete(String id) {
        transactionDao.delete(id);

    }

    @Override
    @Transactional
    public Transactions get(int id) {
        return transactionDao.get(id);
    }

    @Override
    @Transactional
    public Transactions get(String name) {
        return transactionDao.get(name);
    }

    @Override
    @Transactional
    public List<Transactions> getAll() {
        return transactionDao.getAll();
    }

}
