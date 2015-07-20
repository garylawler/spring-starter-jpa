package starter.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import starter.app.model.Test;

@Repository
public interface HelloJpaDao extends JpaRepository<Test, Integer>{

    Test getById(Integer id);
}
