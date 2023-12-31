package com.example.btvn_homestay.service.iplm;

import com.example.btvn_homestay.model.Homestay;
import com.example.btvn_homestay.repository.IHomestayRepository;
import com.example.btvn_homestay.service.IHomestayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomestayService implements IHomestayService {
    @Autowired
    IHomestayRepository iHomestayRepository;

    @Override
    public List<Homestay> findAll() {
        return iHomestayRepository.findAll();
    }


    @Override
    public Optional<Homestay> findById(Long id) {
        return iHomestayRepository.findById(id);
    }
    @Override
    public void save(Homestay homestay) {
        iHomestayRepository.save(homestay);
    }

    @Override
    public void delete(Long id) {
        iHomestayRepository.deleteById(id);
    }

    @Override
    public Page<Homestay> findAllPage(Pageable pageable) {
        return iHomestayRepository.findAll(pageable);
    }
    @Override
    public List<Homestay> findAllByName(String name){
        return iHomestayRepository.findAllByNameContaining(name);
    }

    @Override
    public List<Homestay> findAllByPriceBetween(Double minPrice, Double maxPrice) {
        return iHomestayRepository.findAllByPriceBetween(minPrice, maxPrice);
    }
}
