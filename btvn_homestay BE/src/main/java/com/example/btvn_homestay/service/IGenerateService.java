package com.example.btvn_homestay.service;

public interface IGenerateService<E> {
    E findById(Long id);
    void save(E e);
    List<E> findAll();
    List<E> findAll();
    Optional<E> findById(Long id);
    void save(E e);
    void delete (Long id);
}
