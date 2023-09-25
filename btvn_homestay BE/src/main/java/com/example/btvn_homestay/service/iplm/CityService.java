package com.example.btvn_homestay.service.iplm;

import com.example.btvn_homestay.model.City;
import com.example.btvn_homestay.model.District;
import com.example.btvn_homestay.repository.ICityRepository;
import com.example.btvn_homestay.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    private ICityRepository cityRepository;
    @Override
    public City findById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()){
            return city.get();
        }
        return null;
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
