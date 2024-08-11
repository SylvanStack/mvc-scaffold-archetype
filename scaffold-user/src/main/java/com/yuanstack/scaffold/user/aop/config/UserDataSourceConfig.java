//package com.yuanstack.scaffold.user.aop;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
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
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "com.yuanstack.scaffold.user.manager",
//        entityManagerFactoryRef = "userEntityManagerFactory"
//)
//public class UserDataSourceConfig {
//
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    @Bean(name = "userDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.user")
//    public DataSource userDataSource() {
//        //return DataSourceBuilder.create().build();
//        return new DruidDataSource();
//    }
//
//    // LocalContainerEntityManagerFactoryBean
//    @Bean
//    public Object userEntityManagerFactory(DataSource userDataSource, JpaProperties jpaProperties) {
//        EntityManagerFactoryBuilder builder = createEntityManagerFactoryBuilder(jpaProperties);
//        return builder.dataSource(userDataSource)
//                .packages("com.yuanstack.scaffold.user.entity")
//                .persistenceUnit("userDataSource").build();
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
//}
