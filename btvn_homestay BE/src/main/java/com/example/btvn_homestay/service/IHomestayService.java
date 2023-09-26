package com.example.btvn_homestay.service;

import com.example.btvn_homestay.model.Homestay;

import java.util.List;

public interface IHomestayService extends IGenerateService<Homestay> {
    void delete(Long id);
    List<Homestay> findAllByName(String name);
}

