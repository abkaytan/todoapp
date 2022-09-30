package com.coderspace.todoapp.repository;

import com.coderspace.todoapp.entity.Customer;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public List<Customer> getCustomersByIdNotNull();
    Customer findByPassword(String password);


}
