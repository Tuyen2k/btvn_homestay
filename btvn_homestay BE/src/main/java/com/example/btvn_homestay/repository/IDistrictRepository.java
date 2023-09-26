package com.example.btvn_homestay.repository;

import com.example.btvn_homestay.model.City;
import com.example.btvn_homestay.model.District;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDistrictRepository extends JpaRepository<District,Long> {
    List<District> findAllByCity(City city);
}
