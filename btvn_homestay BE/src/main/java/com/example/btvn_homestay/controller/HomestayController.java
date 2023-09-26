package com.example.btvn_homestay.controller;

import com.example.btvn_homestay.model.Homestay;
import com.example.btvn_homestay.service.iplm.HomestayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/homestay")
public class HomestayController {
    @Autowired
    HomestayService homestayService;

    @GetMapping
    public List<Homestay> getAllHomestays(){
        return homestayService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> addHomestay(@RequestBody Homestay homestay) {
        homestayService.save(homestay);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public String update(@RequestBody Homestay homestay){
        homestayService.save(homestay);
        return "Da sua";
    }
    @GetMapping("/{id}")
    public Homestay getId(@PathVariable Long id) {
        return homestayService.findById(id).get();
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        homestayService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
