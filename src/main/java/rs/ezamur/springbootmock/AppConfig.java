package rs.ezamur.springbootmock;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan
public class AppConfig {

    org.slf4j.Logger logger = LoggerFactory.getLogger(AppConfig.class);

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

    @Bean
    EntityManagerFactory entityManagerFactory() throws URISyntaxException {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource());

        return bean.getObject();
    }

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        // Putting this value in here since DATABASE_URL returns null although it is set.
        String envValue = "postgres://ksnhojohzxydmr:4wzuTDNTYwBKRVZBOR-zqPRf9G@ec2-54-83-198-111.compute-1.amazonaws.com:5432/d9nireb0hc08c2";
        URI dbUri = new URI(envValue);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?ssl=true";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
}
