package com.example.btvn_homestay.service;

import java.util.List;
import java.util.Optional;

public interface IGenerateService<E> {
    List<E> findAll();
    Optional<E> findById(Long id);
    void save(E e);
    void delete (Long id);
}
