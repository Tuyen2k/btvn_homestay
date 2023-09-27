package com.example.btvn_homestay.controller;

import com.example.btvn_homestay.model.Service;
import com.example.btvn_homestay.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/services")
public class ServiceController {
    @Autowired
    private IService service;

    @GetMapping
    public ResponseEntity<List<Service>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Service> findById(@PathVariable Long id){
        Optional<Service> serviceDB = service.findById(id);
        if (serviceDB.isPresent()){
            return new ResponseEntity<>(serviceDB.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/images/{id}")
//    public ResponseEntity<?> getImage(@PathVariable Long id){
//        String imagePath="webapp/.";
//
//        Resource resource= new ClassPathResource(imagePath);
//        if(resource.exists()){
//            byte[] imgBytes= Files.readAllBytes(Path.of(resource));
//            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imgBytes);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }
}
