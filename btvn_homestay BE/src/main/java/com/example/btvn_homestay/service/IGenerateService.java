package com.example.btvn_homestay.service;

public interface IGenerateService<E> {
    E findById(long id);
    void save(E e);
}
