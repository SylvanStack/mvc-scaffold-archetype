package com.yuanstack.scaffold.user.config;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sylvan
 * @date 2024/08/11  20:29
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "projectEntityManagerFactory",
        transactionManagerRef = "projectTransactionManager",
        basePackages = {"com.yuanstack.scaffold.user.dao.project"})
public class ProjectDataSourceConfig {

    @Resource
    private Environment env;

    @Resource
    @Qualifier("projectDataSource")
    private DataSource projectDataSource;

    @Resource
    private JpaProperties jpaProperties;

    @Resource
    private HibernateProperties properties;

    @Primary
    @Bean(name = "projectEntityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return Objects.requireNonNull(projectEntityManagerFactory(builder).getObject()).createEntityManager();
    }

    @Primary
    @Bean(name = "projectEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean projectEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(projectDataSource)
                .properties(properties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings()))
                .packages("com.yuanstack.scaffold.user.entity.project")
                .persistenceUnit("projectPersistenceUnit")
                .build();
    }


    private Map<String, String> getVendorProperties() {
        Map<String, String> jpaProperties = new HashMap<>(16);
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        jpaProperties.put("hibernate.format_sql", env.getProperty("spring.jpa.hibernate.format_sql"));
        jpaProperties.put("hibernate.dialect", env.getProperty("spring.jpa.hibernate.primary-dialect"));
        jpaProperties.put("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
        return jpaProperties;
    }

    @Primary
    @Bean(name = "projectTransactionManager")
    public PlatformTransactionManager projectTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(projectEntityManagerFactory(builder).getObject()));
    }
}
