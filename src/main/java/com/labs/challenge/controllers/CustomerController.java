package com.labs.challenge.controllers;

import com.labs.challenge.dto.CustomerDto;
import com.labs.challenge.dto.MapperUtils;
import com.labs.challenge.entities.Customer;
import com.labs.challenge.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {

    @Autowired
    protected CustomerService service;

    @Autowired
    protected MapperUtils mapper;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAll() {
        return new ResponseEntity(service.findAll().stream().map(mapper::toDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(params = "queryString")
    public ResponseEntity<List<CustomerDto>> search(@RequestParam String queryString) {
        List<CustomerDto> dtoPage = service.search(queryString).stream().map(mapper::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody CustomerDto entityDto) {
        return new ResponseEntity<>(service.create(mapper.dtoToEntity(entityDto, new Customer())), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> retrieve(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(mapper.toDto(service.retrieve(id)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable(value = "id") String id, @RequestBody CustomerDto entityDto) {
        Customer entity = service.retrieve(id);
        mapper.dtoToEntity(entityDto,entity);
        return new ResponseEntity<>(mapper.toDto(service.update(entity)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
