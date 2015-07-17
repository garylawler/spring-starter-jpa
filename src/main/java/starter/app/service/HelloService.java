package starter.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starter.app.dao.HelloHibernateDao;
import starter.app.dao.HelloJdbcDao;

@Service
public class HelloService {

    public static final String PERSISTENCE_HIBERNATE = "hibernate";
    public static final String PERSISTENCE_JDBC = "jdbc";
    public static final String PERSISTENCE_JPA = "jpa";

    @Autowired
    protected HelloHibernateDao helloHibernateDao;

    @Autowired
    protected HelloJdbcDao helloJdbcDao;

    public String getFromDatabase(String method) {
        if(PERSISTENCE_HIBERNATE.equals(method)) {
            return helloHibernateDao.getHelloViewLocation();
        }
        else if(PERSISTENCE_JDBC.equals(method)) {
            return helloJdbcDao.getHelloViewLocation();
        }
        else {
            throw new RuntimeException("Unknown persistence method");
        }
    }
}
