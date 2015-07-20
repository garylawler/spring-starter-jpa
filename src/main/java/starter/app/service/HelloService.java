package starter.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import starter.app.dao.HelloJpaDao;

@Service
public class HelloService {

    @Autowired
    protected HelloJpaDao helloJpaDao;

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public String getFromDatabase(String method) {
            return helloJpaDao.getById(1).getValue();
    }
}
