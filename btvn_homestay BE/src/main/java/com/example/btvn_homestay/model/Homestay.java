package com.example.btvn_homestay.model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
public class Homestay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_homestay;
    @Column(unique = true)
    private String name;
    private Double price;
    private String description;
    private int max_number_stay;
    private String image;
    @Transient
    private MultipartFile file;
    @ManyToOne
    private Status status;
    @ManyToOne
    private Address address;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "homestay_service",
            joinColumns = @JoinColumn(name = "homestay_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> service;

    public Homestay(Long id_homestay, String name, Double price, String description, int max_number_stay, String image, MultipartFile file, Status status, Address address, List<Service> service) {
        this.id_homestay = id_homestay;
        this.name = name;
        this.price = price;
        this.description = description;
        this.max_number_stay = max_number_stay;
        this.image = image;
        this.file = file;
        this.status = status;
        this.address = address;
        this.service = service;
    }

    public Homestay() {
    }

    public Long getId_homestay() {
        return id_homestay;
    }

    public void setId_homestay(Long id_homestay) {
        this.id_homestay = id_homestay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMax_number_stay() {
        return max_number_stay;
    }

    public void setMax_number_stay(int max_number_stay) {
        this.max_number_stay = max_number_stay;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
