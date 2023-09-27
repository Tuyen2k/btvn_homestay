package com.example.btvn_homestay.service;

import com.example.btvn_homestay.model.Homestay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHomestayService extends IGenerateService<Homestay> {
    void delete(Long id);
    Page<Homestay> findAllPage(Pageable pageable);

    List<Homestay> findAllByName(String name);
    List<Homestay> findAllByPriceBetween(Double minPrice, Double maxPrice);
}

