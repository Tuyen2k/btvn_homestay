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
    public ResponseEntity<Iterable<Homestay>> getAllHomestays() {
        return new ResponseEntity<>(homestayService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addHomestay(@RequestBody Homestay homestay) {
        homestayService.save(homestay);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Homestay homestay,@PathVariable Long id) {
        homestay.setId_homestay(id);
        homestayService.save(homestay);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        homestayService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Iterable<Homestay>> search(String name){
        return new ResponseEntity<>(homestayService.findAllByName(name), HttpStatus.OK);
    }
    @GetMapping("/price")
    public ResponseEntity<Iterable<Homestay>> getHomestaysByPriceRange(@RequestParam("minPrice") Double minPrice,
                                                   @RequestParam("maxPrice") Double maxPrice) {
        return new ResponseEntity<>(homestayService.findAllByPriceBetween(minPrice, maxPrice), HttpStatus.OK);
    }
}
