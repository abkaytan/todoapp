package com.coderspace.todoapp.controller;

import com.coderspace.todoapp.dto.CustomerDTO;
import com.coderspace.todoapp.entity.Customer;
import com.coderspace.todoapp.repository.CustomerRepository;
import com.coderspace.todoapp.service.Impl.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todoapp")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerServiceImpl customerServiceImpl, CustomerRepository customerRepository) {
        this.customerServiceImpl = customerServiceImpl;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/index")
    public String showCustomerList(Model theModel){
        theModel.addAttribute("customers", customerRepository.findAll());
        return "index";
    }


    @PostMapping("/register")
    public ResponseEntity<Customer> saveCustomer (@RequestBody @Valid CustomerDTO customerDTO){
        Optional<Customer> customerResult = customerServiceImpl.saveCustomer(customerDTO);
        return customerResult.map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/customer-list")
    public List<Customer> getCustomerList (){
        return customerServiceImpl.getCustomerList();
    }

}
