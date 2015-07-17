package starter.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import starter.app.model.Test;

@Repository
public class HelloDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    private static final String INDEX = "index";

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public String getHelloViewLocation() {

        jdbcTemplate.queryForRowSet("select * from test");

        sessionFactory.getCurrentSession().get(Test.class, 1);

        return INDEX;
    }
}
