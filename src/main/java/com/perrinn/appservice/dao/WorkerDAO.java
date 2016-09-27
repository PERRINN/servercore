package com.perrinn.appservice.dao;


import com.perrinn.appservice.util.Factory;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by alessandrosilacci on 17/09/16.
 */
public class WorkerDAO<T> {
    protected Class<T> persistentClass;


    public WorkerDAO() {
        this.persistentClass = (Class<T>) getClass().getGenericSuperclass();
    }

    public void save(T entity){
        try {
            Session session = Factory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            System.err.println("Error when saving entity of class "+persistentClass.getClass().getSimpleName()
                    +" full stacktrace:\n"+e.getStackTrace());
        }
    }

    public void edit(T entity){
        try {
            Session session = Factory.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            System.err.println("Error when updating entity of class "+persistentClass.getClass().getSimpleName()
                    +" full stacktrace:\n"+e.getStackTrace());
        }
    }

    public List<T> listAll(T entityType){
        List<T> entities = null;
        try {
            Session session = Factory.getSessionFactory().openSession();
            session.beginTransaction();
            entities = session.createQuery("from "+entityType.getClass().getSimpleName()).list();
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            System.err.println("Error when listing entities of class "+persistentClass.getClass().getSimpleName()
                    +" full stacktrace:\n"+e.getStackTrace());
        }
        return entities;
    }

    public T getById(int id){
        T entity = null;
        try {
            Session session = Factory.getSessionFactory().openSession();
            session.beginTransaction();
            entity = session.load(persistentClass, id);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            System.err.println("Error when getting entity of class "+persistentClass.getClass().getSimpleName()
                    +"with id: "+id+" full stacktrace:\n"+e.getStackTrace());
        }
        return entity;
    }
}
