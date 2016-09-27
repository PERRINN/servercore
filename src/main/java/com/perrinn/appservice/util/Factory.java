package com.perrinn.appservice.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by alessandrosilacci on 18/09/16.
 */
public class Factory {
    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() throws Exception{
        if(sessionFactory == null)
            setUp();
        return sessionFactory;
    }

    private static void setUp() throws Exception{
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try{
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }
    }
}
