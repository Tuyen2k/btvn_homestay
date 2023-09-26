package com.example.btvn_homestay.repository;

import com.example.btvn_homestay.model.Homestay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHomestayRepository extends JpaRepository<Homestay, Long> {

}
