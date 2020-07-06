package com.labs.challenge.repositories;

import com.labs.challenge.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> findByEmail(String email);

    @Query("SELECT c FROM Customer c WHERE c.name = :query OR c.email = :query ")
    List<Customer> search(@Param("query") String query);
}
