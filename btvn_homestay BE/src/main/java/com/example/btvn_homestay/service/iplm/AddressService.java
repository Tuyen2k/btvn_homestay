package com.example.btvn_homestay.service.iplm;

import com.example.btvn_homestay.model.Address;
import com.example.btvn_homestay.model.District;
import com.example.btvn_homestay.repository.IAddressRepository;
import com.example.btvn_homestay.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private IAddressRepository addressRepository;
    @Override
    public Optional<Address> findById(Long id) {
       return addressRepository.findById(id);
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findLast() {
        return addressRepository.findLast();
    }
}

