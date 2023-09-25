package com.example.btvn_homestay.service.iplm;

import com.example.btvn_homestay.model.District;
import com.example.btvn_homestay.model.Ward;
import com.example.btvn_homestay.repository.IWardRepository;
import com.example.btvn_homestay.service.IDistrictService;
import com.example.btvn_homestay.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardService implements IWardService {
    @Autowired
    private IWardRepository wardRepository;
    @Autowired
    private IDistrictService districtService;
    @Override
    public Ward findById(Long id) {
        Optional<Ward> ward = wardRepository.findById(id);
        if (ward.isPresent()){
            return ward.get();
        }
        return null;
    }

    @Override
    public void save(Ward ward) {
        wardRepository.save(ward);
    }

    @Override
    public List<Ward> findAll() {
        return wardRepository.findAll();
    }

    @Override
    public List<Ward> findAllByDistrict(Long id_district) {
        District district = districtService.findById(id_district);
        return wardRepository.findAllByDistrict(district);
    }
}
