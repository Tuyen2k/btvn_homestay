package com.example.btvn_homestay.controller;

import com.example.btvn_homestay.model.District;
import com.example.btvn_homestay.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/districts")
public class DistrictController {
    @Autowired
    private IDistrictService districtService;
    @GetMapping
    public ResponseEntity<List<District>> findAll(){
        return new ResponseEntity<>(districtService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<District> findById(@PathVariable Long id){
        District district = districtService.findById(id);
        if (district != null){
            return new ResponseEntity<>(district, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/city")
    public ResponseEntity<List<District>> findAllByCity(@PathVariable("id") Long id_city){
        List<District> districts = districtService.findAllByCity(id_city);
        if (districts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<>(districts, HttpStatus.OK);
    }
}
