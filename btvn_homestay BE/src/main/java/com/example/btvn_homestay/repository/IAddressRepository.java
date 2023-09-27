package com.example.btvn_homestay.repository;

import com.example.btvn_homestay.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IAddressRepository extends JpaRepository<Address, Long> {
    @Query(nativeQuery = true, value = "select * from address order by id_address desc limit 1;")
    Address findLast();
}
