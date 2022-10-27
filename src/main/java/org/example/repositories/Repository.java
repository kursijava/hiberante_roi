package org.example.repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class Repository<T> {
    private final Session session;
    private final Class<? extends T> classes;
    private Transaction transaction = null;

    protected Repository(Session session, Class<? extends T> classes) {
        this.session = session;
        this.classes = classes;
    }

    public T findById(Integer id) {
        return session.find(classes, id);
    }

    public T save(T entity) {
        try{
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            return entity;
        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            return null;
        }
    }

    public T update(T entity) {
        try{
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            return entity;
        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
            return null;
        }
    }

    public void delete(T entity) {
        try{
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
    }
}
