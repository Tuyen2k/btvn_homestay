package com.example.btvn_homestay.repository;

import com.example.btvn_homestay.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository  extends JpaRepository<Status,Long> {
}
