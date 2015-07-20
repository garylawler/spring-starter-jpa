package starter.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import starter.app.model.Test;

@Repository
public interface HelloJpaDao extends JpaRepository<Test, Integer>{

    Test getById(Integer id);

    @Query(value = "select * from Test where id = :id", nativeQuery = true)
    Test justSomeRandomMethodName(@Param("id") Integer id);
}
