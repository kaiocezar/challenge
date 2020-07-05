package com.labs.challenge.repositories;

import com.labs.challenge.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> findByEmail(String email);
}
