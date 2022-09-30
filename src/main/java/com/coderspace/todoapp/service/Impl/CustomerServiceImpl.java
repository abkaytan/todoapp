package com.coderspace.todoapp.service.Impl;

import com.coderspace.todoapp.dto.CustomerDTO;
import com.coderspace.todoapp.entity.Customer;
import com.coderspace.todoapp.repository.CustomerRepository;
import com.coderspace.todoapp.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setPassword(customerDTO.getPassword());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        return Optional.of(customerRepository.save(customer));
    }

    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.getCustomersByIdNotNull();
    }
}
