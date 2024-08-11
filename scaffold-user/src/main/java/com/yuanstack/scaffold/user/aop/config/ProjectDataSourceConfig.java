//package com.yuanstack.scaffold.user.aop;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import jakarta.annotation.Resource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.sql.DataSource;
//
///**
// * @author Sylvan
// * @date 2024/08/11  22:36
// */
//@Configuration(proxyBeanMethods = false)
//@EnableJpaRepositories(
//        basePackages = "com.yuanstack.scaffold.user",
//        entityManagerFactoryRef = "projectEntityManagerFactory"
//)
//public class ProjectDataSourceConfig {
//
//
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    @Bean(name = "projectDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.project")
//    public DataSource projectDataSource() {
//        //return DataSourceBuilder.create().build();
//        return new DruidDataSource();
//    }
//
//    //LocalContainerEntityManagerFactoryBean
//    @Bean
//    public Object projectEntityManagerFactory(DataSource projectDataSource,
//                                              JpaProperties projectJpaProperties) {
//        EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(projectJpaProperties);
//        return builder.dataSource(projectDataSource)
//                .packages("com.yuanstack.scaffold.user.entity")
//                .persistenceUnit("projectDataSource").build();
//    }
//
//    private EntityManagerFactoryBuilder createEntityManagerFactoryBuilder(JpaProperties jpaProperties) {
//        JpaVendorAdapter jpaVendorAdapter = createJpaVendorAdapter(jpaProperties);
//        return new EntityManagerFactoryBuilder(jpaVendorAdapter, jpaProperties.getProperties(), null);
//    }
//
//    private JpaVendorAdapter createJpaVendorAdapter(JpaProperties jpaProperties) {
//        // ... map JPA properties as needed
//        return new HibernateJpaVendorAdapter();
//    }
//
//
//}