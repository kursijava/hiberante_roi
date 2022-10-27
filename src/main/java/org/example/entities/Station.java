package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stationId;

    private String name;

    @OneToMany(mappedBy = "station")
    private List<Train> trains;

    public Station() {
    }

    public Station(Long stationId, String name, List<Train> trains) {
        this.stationId = stationId;
        this.name = name;
        this.trains = trains;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", name='" + name + '\'' +
                '}';
    }
}
