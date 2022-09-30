package com.coderspace.todoapp.repository;

import com.coderspace.todoapp.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PreAuthorize("hasRole('ROLE_USER')")
public interface TodoRepository extends CrudRepository<Todo, Long> {
    /*@Query(nativeQuery = true, value = "SELECT * FROM todo WHERE customerId=?1")
    public List<Todo> findAllByCustomerId(Long customerId);*/

    List<Todo> findAllByCustomerId (Long id);
//    void deleteByCustomerIdAndId(long customerId, long id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    Todo save(Todo s);

}
