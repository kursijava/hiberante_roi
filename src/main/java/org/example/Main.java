package org.example;

import org.example.configuration.HibernateUtils;
import org.example.entities.Station;
import org.example.entities.Train;
import org.example.repositories.StationRepository;
import org.example.repositories.TrainRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        TrainRepository trainRepository = new TrainRepository(session);
        StationRepository stationRepository = new StationRepository(session);
        Train train = new Train();
        train.setName("Test train");
        Station station = stationRepository.save(new Station());
        train.setStation(station);
//        trainRepository.save(train);
        System.out.println(trainRepository.findByName("Test train"));
    }
}