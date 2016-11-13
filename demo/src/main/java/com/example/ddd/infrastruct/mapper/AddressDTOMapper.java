package com.example.ddd.infrastruct.mapper;

import com.example.ddd.application.AddressDTO;
import com.example.ddd.domain.model.people.Address;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Created by robson on 22/10/16.
 */
@Component
public class AddressDTOMapper extends CustomMapper<AddressDTO, Address> {

    @Override
    public void mapAtoB(AddressDTO addressDTO, Address address, MappingContext context) {

        address.setCity(addressDTO.getCity());
        address.setId(addressDTO.getId());
    }

    @Override
    public void mapBtoA(Address address, AddressDTO addressDTO, MappingContext context) {

        addressDTO.setCity(address.getCity());
        addressDTO.setId(address.getId());
    }
}
