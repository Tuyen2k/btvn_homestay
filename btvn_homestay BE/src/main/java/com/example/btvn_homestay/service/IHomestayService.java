package com.example.btvn_homestay.service;

import com.example.btvn_homestay.model.Homestay;

import java.util.List;

public interface IHomestayService extends IGenerateService<Homestay> {
    List<Homestay> findAll();
    void update(Homestay homestay);
    void delete(long id);
}

