package com.example.btvn_homestay.service.iplm;

import com.example.btvn_homestay.repository.IServiceRepository;
import com.example.btvn_homestay.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceIPLM implements IService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public List<com.example.btvn_homestay.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<com.example.btvn_homestay.model.Service> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void save(com.example.btvn_homestay.model.Service service) {
        serviceRepository.save(service);
    }
}
