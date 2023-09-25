package com.example.btvn_homestay.service;

import java.util.List;

public interface IGenerateService<E> {
    E findById(Long id);
    void save(E e);
    List<E> findAll();
}
