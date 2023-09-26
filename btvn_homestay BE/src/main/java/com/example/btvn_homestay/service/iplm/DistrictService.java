package com.example.btvn_homestay.service.iplm;

import com.example.btvn_homestay.model.City;
import com.example.btvn_homestay.model.District;
import com.example.btvn_homestay.repository.ICityRepository;
import com.example.btvn_homestay.repository.IDistrictRepository;
import com.example.btvn_homestay.service.ICityService;
import com.example.btvn_homestay.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService implements IDistrictService {
    @Autowired
    private IDistrictRepository districtRepository;
    @Autowired
    private ICityService cityService;
    @Override
    public Optional<District> findById(Long id) {
        return districtRepository.findById(id);
    }

    @Override
    public void save(District district) {
        districtRepository.save(district);
    }

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public List<District> findAllByCity(Long id) {
        City city = cityService.findById(id).get();
        return districtRepository.findAllByCity(city);
    }
}
