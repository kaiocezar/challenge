package com.labs.challenge.services;

import com.labs.challenge.entities.Customer;
import com.labs.challenge.exceptions.UniqueEmailException;
import com.labs.challenge.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = {Throwable.class})
public class CustomerService {

    @Autowired
    protected CustomerRepository repository;

    public List<Customer> search(String query){
        return repository.search(query);
    }

    public Customer create(Customer entity) {
        validateCustomer(entity);
        return repository.save(entity);
    }

    private void validateCustomer(Customer entity) {
        if(!repository.findByEmail(entity.getEmail()).isEmpty()){
            throw new UniqueEmailException(entity.getEmail());
        }

    }

    public Customer retrieve(String id) {
        return repository.getOne(id);
    }

    public Customer update(Customer entity) {
        return repository.save(entity);
    }

    public void delete(Customer entity) { repository.delete(entity); }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

}
