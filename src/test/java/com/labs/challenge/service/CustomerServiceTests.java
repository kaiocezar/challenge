package com.labs.challenge.service;

import com.labs.challenge.entities.Customer;
import com.labs.challenge.exceptions.UniqueEmailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
public class CustomerServiceTests {

    @Autowired
    CustomerService service;

    @Test
    public void customerListTest() {
        Assertions.assertEquals(0,service.findAll().size());
    }

    @Test
    public void customerCreateTest() {
        Customer customer = createCustomer();
        Assertions.assertNotNull(customer.getId());
    }



    @Test
    public void customerRetrieveTest() {
        Customer customer = createCustomer();
        Assertions.assertEquals(customer.getId(), service.retrieve(customer.getId()).getId());
    }

    @Test
    public void customerUpdateTest() {
        String newName = "Donatelo";
        Customer customer = createCustomer();
        customer.setName(newName);
        service.update(customer);
        Assertions.assertEquals(newName, service.retrieve(customer.getId()).getName());
    }

    @Test
    public void customerDeleteTest() {
        Customer customer = createCustomer();
        Assertions.assertEquals(1,service.findAll().size());
        service.delete(customer);
        Assertions.assertEquals(0,service.findAll().size());
    }

    @Test
    public void customerDeleteByIdTest() {
        Customer customer = createCustomer();
        Assertions.assertEquals(1,service.findAll().size());
        service.deleteById(customer.getId());
        Assertions.assertEquals(0,service.findAll().size());
    }

    private Customer createCustomer() {
        Customer customer = new Customer();
        customer.setName("Kaio Cezar");
        customer.setEmail("kaiocezar.7@gmail.com");
        customer = service.create(customer);
        return customer;
    }

    @Test
    public void customerDuplicateEmailTest() {
        createCustomer();
        Assertions.assertThrows(UniqueEmailException.class, () -> createCustomer());
    }
}
