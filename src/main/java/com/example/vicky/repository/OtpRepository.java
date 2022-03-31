package com.example.vicky.repository;

import com.example.vicky.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface OtpRepository extends JpaRepository<Otp,Long> {


}
