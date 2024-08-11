//package com.yuanstack.scaffold.user.aop;
//
//import com.yuanstack.scaffold.user.aop.factory.RoutingEntityManagerFactory;
//import jakarta.annotation.Resource;
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Sylvan
// * @date 2024/08/11  21:38
// */
//@Configuration
//public class EntityManagerFactoryConfig {
//
//    @Resource
//    private Object projectEntityManagerFactory;
//
//    @Resource
//    private Object userEntityManagerFactory;
//
//
//    @Bean
//    public EntityManagerFactory entityManager() {
//        String dataSourceType = EntityManagerContextHolder.getEntityManagerFactoryType();
//        RoutingEntityManagerFactory routingEntityManagerFactory = new RoutingEntityManagerFactory();
//        Map<String, Object> targetEntityManagerFactorys = new HashMap<String, Object>();
//        // 主实体管理工厂
//        targetEntityManagerFactorys.put("project", projectEntityManagerFactory);
//        // 次要实体管理工厂
//        targetEntityManagerFactorys.put("user", userEntityManagerFactory);
//
//        // 配置实体管理工厂
//        routingEntityManagerFactory.setTargetEntityManagerFactorys(targetEntityManagerFactorys);
//        // 设置默认实体管理工厂
//        routingEntityManagerFactory.setDefaultTargetEntityManagerFactory(projectEntityManagerFactory);
//        return routingEntityManagerFactory;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager tm = new JpaTransactionManager();
//        tm.setEntityManagerFactory(entityManager());
//        return tm;
//    }
//
//}