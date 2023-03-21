zxzpackage com.se.mycompany.homeware.daoImpl;

import com.se.mycompany.homeware.dao.OrderedDao;
import com.se.mycompany.homeware.model.Ordered;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderedDaoImpl implements OrderedDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insert(Ordered ordered) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(ordered);
    }

    @Override
    public void edit(Ordered ordered) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Ordered get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Ordered get(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public List<Ordered> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ordered> theQuery = currentSession.createQuery("from Ordered", Ordered.class);
        List<Ordered> ordereds = theQuery.getResultList();
        return ordereds;
    }

}
