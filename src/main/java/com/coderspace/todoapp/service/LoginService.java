package com.coderspace.todoapp.service;


import com.coderspace.todoapp.dto.LoginDTO;
import org.springframework.stereotype.Service;


public interface LoginService {
    public void save(LoginDTO loginDTO);
}
