package com.example.btvn_homestay.controller;

import com.example.btvn_homestay.model.Homestay;
import com.example.btvn_homestay.service.IAddressService;
import com.example.btvn_homestay.service.IHomestayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    IAddressService addressService;

    @GetMapping
    public List<Homestay> getAllHomestays() {
        return homestayService.findAll();
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

    @PostMapping("/update")
    public String update(@RequestBody Homestay homestay) {
        homestayService.save(homestay);
        return "Da sua";
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
}
