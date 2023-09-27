package com.example.btvn_homestay.repository;

import com.example.btvn_homestay.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository  extends JpaRepository<Address,Long> {
}
