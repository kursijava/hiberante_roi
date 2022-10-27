package org.example.repositories;

import org.example.entities.Train;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TrainRepository extends Repository<Train> {
    private final Session session;
    public TrainRepository(Session session) {
        super(session, Train.class);
        this.session = session;
    }

    public Train findByName(String name){
        String hql = "select train from Train train where train.name = :name";
        Query<Train> query = session.createQuery(hql, Train.class);
        query.setParameter("name", name);
        return query.getSingleResultOrNull();
    }
}
