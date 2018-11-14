package com.mev.web.config;


import java.io.BufferedWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.mev.web")
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {
 
    @Autowired
    private Environment environment;
 
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
    	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    	sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.mev.web" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
     
    @Bean
    public DataSource dataSource() {
    	String connectString = System.getenv("MYSQLCONNSTR_localdb");

        String database = "";
        String port = "";
        String username = "";
        String password = "";

        String[] strArray = connectString.split(";");
        for (int i = 0; i < strArray.length; i++) {
            String[] paramArray = strArray[i].split("=");
            switch (i) {
            case 0:
                database = paramArray[1];
                continue;
            case 1:
                port = paramArray[1];
                continue;
            case 2:
                username = paramArray[1];
                continue;
            case 3:
                password = paramArray[1];
                continue;
            }
        }

        String url = "jdbc:mysql://" + port + "/" + database + "?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(url);//MYSQLCONNSTR_localdb
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
     
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;        
    }
     
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
}