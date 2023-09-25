package com.example.btvn_homestay.controller;

import com.example.btvn_homestay.service.IAddressService;
import com.example.btvn_homestay.service.ICityService;
import com.example.btvn_homestay.service.IDistrictService;
import com.example.btvn_homestay.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICityService cityService;
    @Autowired
    private IDistrictService districtService;
    @Autowired
    private IWardService wardService;



}
