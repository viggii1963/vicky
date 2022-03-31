package com.example.vicky.studentService;

import com.example.vicky.entity.Otp;
import com.example.vicky.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OtpService {
    @Autowired
    private OtpRepository otpRepository;

      boolean check(Long customerId) {
          Optional<Otp> otp=otpRepository.findById(customerId);
          if(otp.isEmpty()){
              return true;
          }
          else
              return false;

    }

    public String saveOtp(Otp otp){
        otpRepository.save(otp);
        return "OTP saved successfully and the otp is "+otp.getOtp();

    }

    public List<Otp> findById(Long customerId) {
        return otpRepository.findAllById(Collections.singleton(customerId));
    }
}
