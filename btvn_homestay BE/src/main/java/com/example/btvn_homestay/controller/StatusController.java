package com.example.btvn_homestay.controller;

import com.example.btvn_homestay.model.Status;
import com.example.btvn_homestay.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/statuses")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> findAll() {
        List<Status> statusList = statusService.findAll();
        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }

    @GetMapping("/{id_status}")
    public ResponseEntity<Status> findOne(@PathVariable Long id_status) {
        Optional<Status> status = statusService.findById(id_status);
        if (status.isPresent()) {
            return new ResponseEntity<>(status.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Status status) {
        statusService.save(status);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/{id_status}")
    public ResponseEntity<Void> update(@RequestBody Status status, @PathVariable Long id_status) {
        Optional<Status> status1 = statusService.findById(id_status);
        if (status1.isPresent()) {
            status.setId_status(id_status);
            statusService.save(status);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id_status}")
    public ResponseEntity<Void> delete(@PathVariable ("id_status")Long id_status) {
        Optional<Status> status = statusService.findById(id_status);
        if (status.isPresent()) {
            statusService.delete(id_status);
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
