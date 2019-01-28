package com.spark.ex.launcher;

import com.spark.ex.hibernatepojo.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfiguration {
    private static SessionFactory sessionFactory = null;

    public SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            init();
            return sessionFactory;
        }
        return sessionFactory;
    }
    public void init() {
        System.out.println("Hibernate Initializing...");
        HibernateConfiguration hiberConfig = new HibernateConfiguration();
        sessionFactory = hiberConfig.configureSessionFactory();
        System.out.println("Hibernate Initialized.");
    }

    public SessionFactory configureSessionFactory() {


        Configuration configuration = new Configuration().setProperties(setSessionFactoryProperties());

        configuration.addAnnotatedClass(ERS_Users.class);
        configuration.addAnnotatedClass(ERS_Reimbursement.class);
        configuration.addAnnotatedClass(ERS_Reimbursement_Status.class);
        configuration.addAnnotatedClass(ERS_Reimbursement_Type.class);
        configuration.addAnnotatedClass(ERS_User_Roles.class);
        System.out.println("added clas");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("before return");
        sessionFactory =configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }


    private Properties setSessionFactoryProperties() {
        Properties temp = new Properties();

        temp.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        temp.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        temp.setProperty("hibernate.connection.username", "JoeStar");
        temp.setProperty("hibernate.connection.password", "G0ld3n_WIND");
        temp.setProperty("hibernate.connection.url", "jdbc:postgresql://project-1.ctsx6ayoh3eb.us-east-2.rds.amazonaws.com:5432/Project_1");
//	        jdbc:postgresql://bankdb.cyepeidfgoiu.us-east-2.rds.amazonaws.com:5432/mybankdb
        temp.setProperty("hibernate.connection.pool_size", "1");
        System.out.println("inside pool");
//	        temp.setProperty("hibernate.hbm2ddl.auto", "validate");
        //TODO check for error here
        temp.setProperty("hibernate.show_sql", "true");
        temp.setProperty("hibernate.format_sql", "true");
        System.out.println("before return");

        return temp;
    }

}
