//package com.yuanstack.scaffold.user.aop;
//
///**
// * 用来保存当前线程的EntityManagerFactory名称 的工具类
// *
// * @author Sylvan
// * @date 2024/08/11  21:36
// */
//public class EntityManagerContextHolder {
//    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
//
//    public static void setEntityManagerFactoryType(String entityManagerFactoryType) {
//        contextHolder.set(entityManagerFactoryType);
//    }
//
//    public static String getEntityManagerFactoryType() {
//        return contextHolder.get();
//    }
//
//    public static void clearEntityManagerFactoryType() {
//        contextHolder.remove();
//    }
//}