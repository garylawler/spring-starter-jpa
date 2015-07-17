package starter.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import starter.app.model.Test;

@Repository
public class HelloHibernateDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public String getHelloViewLocation() {
        Object o = sessionFactory.getCurrentSession().get(Test.class, 1);
        if(o instanceof Test) {
            return ((Test)o).getValue();
        }
        throw new RuntimeException();
    }
}
