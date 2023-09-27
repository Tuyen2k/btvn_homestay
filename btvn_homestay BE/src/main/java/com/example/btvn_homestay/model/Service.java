package com.example.btvn_homestay.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_service;
    @Column(unique = true)
    private String name;


    public Service(Long id_service, String name) {
        this.id_service = id_service;
        this.name = name;

    }

    public Service() {
    }

    public Long getId_service() {
        return id_service;
    }

    public void setId_service(Long id_service) {
        this.id_service = id_service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
