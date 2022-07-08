package com.example.clinica.service;

import com.example.clinica.entities.Address;
import com.example.clinica.entities.AddressDTO;
import com.example.clinica.repository.IAddressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AddressService {
    private final IAddressRepository addressRepository;
    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Autowired
    ObjectMapper mapper;

    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = mapper.convertValue(addressDTO, Address.class);
        addressRepository.save(address);
        return addressDTO;
    }

    public AddressDTO modifyAddress(AddressDTO addressDTO) {
        Address address = mapper.convertValue(addressDTO, Address.class);
        addressRepository.save(address);
        return addressDTO;
    }

    public AddressDTO findAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        AddressDTO addressDTO = null;
        if (address.isPresent()){
            addressDTO = mapper.convertValue(address, AddressDTO.class);
        }
        return addressDTO;
    }

    public Set<AddressDTO> getAllAddress() {
        List<Address> addressList = addressRepository.findAll();
        Set<AddressDTO> addressDTOList = new HashSet<>();

        for (Address address : addressList) {
            addressDTOList.add(mapper.convertValue(address, AddressDTO.class));
        }

        return addressDTOList;
    }

    public void eliminateAddressById(Long id) {
        addressRepository.deleteById(id);
    }
}
