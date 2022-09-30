package com.coderspace.todoapp.service;


import com.coderspace.todoapp.dto.CustomerDTO;
import com.coderspace.todoapp.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Optional<Customer> saveCustomer(CustomerDTO customerDTO);
    public List<Customer> getCustomerList();

}
