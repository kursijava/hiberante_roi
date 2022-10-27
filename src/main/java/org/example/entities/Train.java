package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table()
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "station")
    private Station station;

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", name='" + name + '\'' +
                ", station=" + station +
                '}';
    }
}
