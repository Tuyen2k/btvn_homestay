package com.example.btvn_homestay.model;

import javax.persistence.*;

@Entity
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ward;
    private String name;

    @ManyToOne
    private District district;

    public Ward() {
    }

    public Ward(Long id_ward, String name, District district) {
        this.id_ward = id_ward;
        this.name = name;
        this.district = district;
    }

    public Long getId_ward() {
        return id_ward;
    }

    public void setId_ward(Long id_ward) {
        this.id_ward = id_ward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
