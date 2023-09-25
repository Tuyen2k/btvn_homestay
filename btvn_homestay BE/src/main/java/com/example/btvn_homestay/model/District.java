package com.example.btvn_homestay.model;

import javax.persistence.*;

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_district;
    private String name;
    @ManyToOne
    private City city;

    public District(Long id_district, String name, City city) {
        this.id_district = id_district;
        this.name = name;
        this.city = city;
    }

    public District() {
    }

    public Long getId_district() {
        return id_district;
    }

    public void setId_district(Long id_district) {
        this.id_district = id_district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
