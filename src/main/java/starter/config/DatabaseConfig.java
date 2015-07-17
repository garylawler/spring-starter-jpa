package starter.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public DataSource getDatasource() throws Exception {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        dbProperties.setProperty("url", "jdbc:mysql://localhost/test");
        return BasicDataSourceFactory.createDataSource(dbProperties);
    }

    @Bean
    @Autowired
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setPackagesToScan("starter.app.model");
        sessionFactory.setDataSource(dataSource);
        sessionFactory.afterPropertiesSet();

        return sessionFactory.getObject();
    }

    @Bean
    @Autowired
    public JdbcTemplate getDdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @Autowired
    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
