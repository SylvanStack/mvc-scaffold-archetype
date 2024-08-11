package com.yuanstack.scaffold.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源配置
 *
 * @author Sylvan
 * @date 2024/08/11  20:29
 */
@Configuration
public class DataSourceConfig {

    /**
     * 第一个数据连接，默认优先级最高 （项目数据源）
     */
    @Primary
    @Bean(name = "projectDataSource")
    @Qualifier("projectDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.project")
    public DataSource projectDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    /**
     * 用户数据源
     */
    @Bean(name = "userDataSource")
    @Qualifier("userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
}
