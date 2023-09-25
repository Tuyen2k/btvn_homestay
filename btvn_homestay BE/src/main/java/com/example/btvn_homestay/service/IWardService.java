package com.example.btvn_homestay.service;

import com.example.btvn_homestay.model.District;
import com.example.btvn_homestay.model.Ward;

import java.util.List;

public interface IWardService extends IGenerateService<Ward> {
    List<Ward> findAllByDistrict(Long id_district);
}
