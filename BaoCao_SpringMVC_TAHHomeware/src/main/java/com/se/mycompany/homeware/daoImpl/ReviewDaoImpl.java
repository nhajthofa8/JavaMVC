package com.se.mycompany.homeware.daoImpl;

import com.se.mycompany.homeware.dao.ReviewDao;
import com.se.mycompany.homeware.model.Review;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(Review review) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(review);
    }

    @Override
    public void edit(Review review) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Review tempReview = currentSession.get(Review.class, id);
        currentSession.delete(tempReview);
    }

    @Override
    public Review get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Review get(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Review> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Review> theQuery = currentSession.createQuery("from Review", Review.class);
        List<Review> reviews = theQuery.getResultList();
        return reviews;
    }

    @Override
    public List<Review> getReviewById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Review> reviews;
        Query<Review> theQuery = currentSession.createQuery("from Review where product_id= :id", Review.class);
        theQuery.setParameter("id", id);
        reviews = theQuery.getResultList();
        return reviews;
    }

}
