package com.example.btvn_homestay.controller;

import com.example.btvn_homestay.model.Homestay;
import com.example.btvn_homestay.service.IStatusService;
import com.example.btvn_homestay.service.iplm.AddressService;
import com.example.btvn_homestay.service.IAddressService;
import com.example.btvn_homestay.service.IHomestayService;
import com.example.btvn_homestay.service.iplm.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/homestay")
public class HomestayController {
    @Value("${upload}")
    private String upload;
    @Autowired
    IHomestayService homestayService;
    @Autowired
    private IStatusService statusService;
    @Autowired
    private IAddressService addressService;
    @Value("${image}")
    private String image;



    @GetMapping
    public ResponseEntity<Iterable<Homestay>> getAllHomestays() {
        return new ResponseEntity<>(homestayService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addHomestay(@RequestPart("homestay") Homestay homestay,
                                            @RequestPart(value = "file", required = false) MultipartFile file) {
            if (file.getSize() != 0) {
                String name = file.getOriginalFilename();
                try {
                    FileCopyUtils.copy(file.getBytes(), new File(upload + name));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                homestay.setImage(name);
            } else {
                if (Objects.equals(homestay.getId_homestay(), null)) {
                    homestay.setImage("fall-8192375_640.png");
                }
            }
        if (Objects.equals(homestay.getAddress().getId_address(), null)) {
            addressService.save(homestay.getAddress());
            homestay.setAddress(addressService.findLast());
        }
        homestayService.save(homestay);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Homestay homestay,@PathVariable Long id) {
        homestay.setId_homestay(id) ;
        homestayService.save(homestay);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Homestay> getId(@PathVariable Long id) {
        Optional<Homestay> homestay = homestayService.findById(id);
        if (homestay.isPresent()) {
            return new ResponseEntity<>(homestay.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        homestayService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<Homestay>> findAllPage(@PageableDefault(value = 8)Pageable pageable){
        return new ResponseEntity<>(homestayService.findAllPage(pageable),HttpStatus.OK);
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
