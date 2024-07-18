package com.testtask.theraventesttask.repository;

import com.testtask.theraventesttask.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}