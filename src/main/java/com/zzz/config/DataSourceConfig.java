package com.zzz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by hushengjun on 2017/9/15.
 */
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceConfig {
    @Autowired
    private DataSourceProperties dataSourceProperties;

//    @Bean(name = "dataSource1")
//    public DataSource dataSource() {
//        return null;
//    }

}
