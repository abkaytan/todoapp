package com.coderspace.todoapp.controller;

import com.coderspace.todoapp.dto.LoginDTO;
import com.coderspace.todoapp.entity.Customer;
import com.coderspace.todoapp.exception.UsernamePasswordMissMatchException;
import com.coderspace.todoapp.repository.CustomerRepository;
import com.coderspace.todoapp.service.Impl.LoginServiceImpl;
import com.coderspace.todoapp.service.LoginService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/todoapp")
public class LoginController {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private LoginServiceImpl loginService;
    private CustomerRepository customerRepository;

    public LoginController(BCryptPasswordEncoder bCryptPasswordEncoder, LoginServiceImpl loginService, CustomerRepository customerRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.loginService = loginService;
        this.customerRepository = customerRepository;
    }


    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@Valid @RequestBody LoginDTO loginDTO) {

//        Optional<Customer> customerCheck = customerRepository.findById(1L);
        Customer customerCheck = customerRepository.findByPassword(loginDTO.getPassword());

        if(customerCheck.getName().equals(loginDTO.getUsername())){
            String token = bCryptPasswordEncoder.encode(loginDTO.getPassword());
            loginDTO.setPassword(token);
            loginService.save(loginDTO);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } else {
            throw new UsernamePasswordMissMatchException("There is no customer with this username or password");
        }
    }
}
