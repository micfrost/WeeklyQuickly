package dev.micfro.weeklyquikclyapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initializeDatabase();
    }

    private void initializeDatabase() {
        jdbcTemplate.execute("USE `weeklyquickly`;");
        jdbcTemplate.execute("DROP TABLE IF EXISTS `authorities`;");
        jdbcTemplate.execute("DROP TABLE IF EXISTS `users`;");

        jdbcTemplate.execute("CREATE TABLE `users` ("
                + "`username` varchar(50) NOT NULL,"
                + "`password` char(68) NOT NULL,"
                + "`enabled` tinyint NOT NULL,"
                + "PRIMARY KEY (`username`)"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

        jdbcTemplate.execute("INSERT INTO `users` VALUES "
                + "('Julian','{bcrypt}$2a$12$kKHuxV3aEZ8d9oXJSjPLQeBodqmfBUCieCTb/ELOF31jJt.HolObq',1),"
                + "('Aleksandra','{bcrypt}$2a$12$kKHuxV3aEZ8d9oXJSjPLQeBodqmfBUCieCTb/ELOF31jJt.HolObq',1),"
                + "('Michal','{bcrypt}$2a$12$kKHuxV3aEZ8d9oXJSjPLQeBodqmfBUCieCTb/ELOF31jJt.HolObq',1);");

//        pass123

        jdbcTemplate.execute("CREATE TABLE `authorities` ("
                + "`username` varchar(50) NOT NULL,"
                + "`authority` varchar(50) NOT NULL,"
                + "UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),"
                + "CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

        jdbcTemplate.execute("INSERT INTO `authorities` VALUES "
                + "('Julian','ROLE_CUSTOMER'),"
                + "('Aleksandra','ROLE_CUSTOMER'),"
                + "('Aleksandra','ROLE_EMPLOYEE'),"
                + "('Michal','ROLE_CUSTOMER'),"
                + "('Michal','ROLE_EMPLOYEE'),"
                + "('Michal','ROLE_ADMIN');");
    }
}
