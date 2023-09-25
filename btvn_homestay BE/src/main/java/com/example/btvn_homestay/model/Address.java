package com.example.btvn_homestay.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_address;
    @ManyToOne
    private City city;
    @ManyToOne
    private District district;
    @ManyToOne
    private Ward ward;

    private String address_detail;

    public Address(Long id_address, City city, District district, Ward ward, String address_detail) {
        this.id_address = id_address;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address_detail = address_detail;
    }

    public Address() {
    }

    public Long getId_address() {
        return id_address;
    }

    public void setId_address(Long id_address) {
        this.id_address = id_address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }
}
