package com.labs.challenge.dto;

import com.labs.challenge.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils {

    public CustomerDto toDto(Customer entity){
        CustomerDto dto = new CustomerDto();
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setId(entity.getId());
        return  dto;
    }

    public Customer dtoToEntity(CustomerDto dto,Customer entity){
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        return  entity;
    }

}
