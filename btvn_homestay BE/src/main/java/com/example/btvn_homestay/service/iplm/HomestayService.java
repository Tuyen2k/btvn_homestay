package com.example.btvn_homestay.service.iplm;

import com.example.btvn_homestay.model.Homestay;
import com.example.btvn_homestay.repository.IHomestayRepository;
import com.example.btvn_homestay.service.IHomestayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomestayService implements IHomestayService {
    @Autowired
    IHomestayRepository iHomestayRepository;

    @Override
    public List<Homestay> findAll() {
        return(List<Homestay>) iHomestayRepository.findAll();
    }


    @Override
    public Optional<Homestay> findById(Long id) {
      return   iHomestayRepository.findById(id);

    }
    @Override
    public void save(Homestay homestay) {
        iHomestayRepository.save(homestay);
    }

    @Override
    public void update(Homestay homestay) {
        iHomestayRepository.save(homestay);
    }

    @Override
    public void delete(Long id) {
        iHomestayRepository.deleteById(id);
    }
}
