package com.example.btvn_homestay.model;

import javax.persistence.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_city;
    @Column(unique = true)
    private String name;

    public City(Long id_city, String name) {
        this.id_city = id_city;
        this.name = name;
    }

    public City() {
    }

    public Long getId_city() {
        return id_city;
    }

    public void setId_city(Long id_city) {
        this.id_city = id_city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
