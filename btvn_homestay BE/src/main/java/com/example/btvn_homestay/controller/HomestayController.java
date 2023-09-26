package com.example.btvn_homestay.controller;

import com.example.btvn_homestay.model.Homestay;
import com.example.btvn_homestay.service.iplm.AddressService;
import com.example.btvn_homestay.service.iplm.HomestayService;
import com.example.btvn_homestay.service.iplm.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/homestay")
public class HomestayController {
    @Autowired
    HomestayService homestayService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private AddressService addressService;
    @Value("${image}")
    private String image;



    @GetMapping
    public List<Homestay> getAllHomestays() {
        return homestayService.findAll();
    }

@PostMapping
public  ResponseEntity<Void>save(@RequestPart("homestay") Homestay homestay,
                                 @RequestPart("file") MultipartFile multipartFile){
    if (multipartFile.getSize() != 0) {
        String name = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(image + name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        homestay.setImage(name);
    } else {
        homestay.setImage("fall-8192375_640.png");
    }
    homestayService.save(homestay);
    return  new ResponseEntity<>(HttpStatus.OK);
}

    @PostMapping("/update")
    public String update(@RequestBody Homestay homestay) {
        homestayService.save(homestay);
        return "Da sua";
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        homestayService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
