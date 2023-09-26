package com.example.btvn_homestay.controller;

import com.example.btvn_homestay.model.Address;
import com.example.btvn_homestay.service.iplm.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.example.btvn_homestay.service.IAddressService;
import com.example.btvn_homestay.service.ICityService;
import com.example.btvn_homestay.service.IDistrictService;
import com.example.btvn_homestay.service.IWardService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
  private AddressService addressService ;
    @GetMapping
    public ResponseEntity<List<Address>> findAll(){
        List<Address> addresses =addressService.findAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
    @GetMapping("{id_address}")
    public  ResponseEntity<Address>findOne(@PathVariable Long id_address){
        Optional<Address>address =addressService.findById(id_address);
        if(address.isPresent()){
            return new ResponseEntity<>(address.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
