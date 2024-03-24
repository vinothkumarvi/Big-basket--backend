package com.product.product.controller;

import org.springframework.web.bind.annotation.RestController;

import com.product.product.model.Customer;
import com.product.product.repository.CustomerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addNewCustomer")
    public Customer addCustomer(@RequestBody Customer customer) throws Exception {

        Customer isExecistCustomer = customerRepository.findByPhoneNumber(customer.getPhoneNumber());
        if (isExecistCustomer != null) {
            throw new Exception("You have a Account in this Number " + customer.getPhoneNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer() throws Exception {
        List<Customer> customer = customerRepository.findAll();
        return customer;
    }

}
