package com.example.btvn_homestay.repository;

import com.example.btvn_homestay.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository  extends JpaRepository<Status,Long> {
}
