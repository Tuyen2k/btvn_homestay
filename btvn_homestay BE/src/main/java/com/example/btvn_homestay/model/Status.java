package com.example.btvn_homestay.model;

import javax.persistence.*;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_status;
    @Column(unique = true)
    private String name;

    public Status() {
    }

    public Status(Long id_status, String name) {
        this.id_status = id_status;
        this.name = name;
    }

    public Long getId_status() {
        return id_status;
    }

    public void setId_status(Long id_status) {
        this.id_status = id_status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
