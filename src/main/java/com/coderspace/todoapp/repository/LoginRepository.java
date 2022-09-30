package com.coderspace.todoapp.repository;

import com.coderspace.todoapp.entity.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {
    Login findByUsername(String username);
}
