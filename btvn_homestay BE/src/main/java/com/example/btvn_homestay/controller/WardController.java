package com.example.btvn_homestay.controller;

import com.example.btvn_homestay.model.Ward;
import com.example.btvn_homestay.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/wards")
public class WardController {
    @Autowired
    private IWardService wardService;
    @GetMapping
    public ResponseEntity<List<Ward>> findAll(){
        return new ResponseEntity<>(wardService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ward> findById(@PathVariable Long id){
       Optional<Ward> ward = wardService.findById(id);
        if (ward.isPresent()){
            return new ResponseEntity<>(ward.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/district")
    public ResponseEntity<List<Ward>> findAllByDistrict(@PathVariable("id") Long id_district){
        List<Ward> wards = wardService.findAllByDistrict(id_district);
        if (wards.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new  ResponseEntity<>(wards, HttpStatus.OK);
    }
}
