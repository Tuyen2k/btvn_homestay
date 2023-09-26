package com.example.btvn_homestay.service.iplm;

import com.example.btvn_homestay.model.Status;
import com.example.btvn_homestay.repository.IStatusRepository;
import com.example.btvn_homestay.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService  implements IStatusService {
    @Autowired
    IStatusRepository statusRepository;

    @Override
    public Optional<Status> findById(Long id_status) {
        return statusRepository.findById(id_status);

    }

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void delete(Long id_status) {
        statusRepository.deleteById(id_status);
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
