package starter.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starter.app.dao.HelloJpaDao;

@Service
public class HelloService {

    @Autowired
    protected HelloJpaDao helloJpaDao;

    public String getFromDatabase(String method) {
            return helloJpaDao.getById(1).getValue();
    }
}
