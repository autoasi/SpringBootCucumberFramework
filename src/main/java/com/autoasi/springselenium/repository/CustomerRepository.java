package com.autoasi.springselenium.repository;

import com.autoasi.springselenium.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> { // <entity name>,<primary key type>
    List<Customer> findByFirstNameStartingWith(String startsWith); // sql statement
    List<Customer> findByDobBetween(Date from, Date to); // sql statement
}
