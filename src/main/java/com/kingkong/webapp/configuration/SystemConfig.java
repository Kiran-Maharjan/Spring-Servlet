/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kingkong.webapp.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author kiran
 */

@Configuration
@EnableWebMvc
public class SystemConfig {
    
    @Bean
    public ViewResolver geViewResolver(){
        //--creates.. key. .value pair
        InternalResourceViewResolver vr=new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
        return vr;
    }
    /*
    @Bean
    public PropertyPlaceholderConfigurer getPropertyConfigurer(){
        PropertyPlaceholderConfigurer pc=new PropertyPlaceholderConfigurer();
        pc.setLocation(new FileSystemResource("/WEB-INF/db/jdbc.properties"));
        return pc;
    }*/
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/company");
        ds.setUsername("root");
        ds.setPassword("");
        return ds;
    }
    
    @Bean
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }
}
