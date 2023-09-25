package com.example.btvn_homestay.service;

import com.example.btvn_homestay.model.District;
import com.example.btvn_homestay.model.Ward;

import java.util.List;

public interface IDistrictService extends IGenerateService<District> {
    List<District> findAllByCity(Long id);
}
