package com.example.vicky.studentService;

import com.example.vicky.entity.Customer;
import com.example.vicky.repository.CustomerRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    public CustomerRepostitory customerRepostitory;

    @Override
    public Customer enterCustomer(Customer student) {
        return customerRepostitory.save(student);
    }





    @Override
    public List<Customer> getCustomer() {
        return customerRepostitory.findAll();
    }

    @Override
    public List<Customer> getById(Long id) {
        return customerRepostitory.findByCustomerId(id);
    }

    @Override
    public int getOtp() {
        int a=(int)(Math.random()*1000000);
        if(a<100000){
            a= CustomerService.check();

        }
        return a;
    }

    @Override
    public List<Customer> checkmailID(String emailId) {

        return customerRepostitory.findByEmailId(emailId);
    }

    @Override
    public List<Customer> checkPhoneNumber(Long phoneNumber) {
        return customerRepostitory.findByPhoneNumber(phoneNumber);
    }


}
