package com.example.btvn_homestay.repository;

import com.example.btvn_homestay.model.District;
import com.example.btvn_homestay.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWardRepository extends JpaRepository<Ward, Long> {

    List<Ward> findAllByDistrict(District district);

}
