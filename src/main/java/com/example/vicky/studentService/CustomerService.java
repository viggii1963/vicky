package com.example.vicky.studentService;

import com.example.vicky.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
     Customer enterCustomer(Customer student);
     List<Customer> getCustomer();
     List<Customer> getById(Long id);
     int getOtp();
     static int check()
     {
          int b = (int) (Math.random() * 10000);
          if (b < 100000) {
               return check();
          } else
               return b;
     }

     List<Customer> checkmailID(String emailId);

     List<Customer> checkPhoneNumber(Long phoneNumber);
}
