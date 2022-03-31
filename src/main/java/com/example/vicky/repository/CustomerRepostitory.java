package com.example.vicky.repository;

import com.example.vicky.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CustomerRepostitory extends JpaRepository<Customer,Long> {


    List<Customer> findByCustomerId(Long id);

    List<Customer> findByEmailId(String emailId);

    List<Customer> findByPhoneNumber(Long phoneNumber);
}
