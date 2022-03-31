package com.example.vicky;


import com.example.vicky.entity.Customer;
import com.example.vicky.entity.Otp;
import com.example.vicky.studentService.CustomerService;
import com.example.vicky.studentService.EmailSenderService;
import com.example.vicky.studentService.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    public CustomerService customerService;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private OtpService otpService;

    @PostMapping(value = "/customer")
    public String enterStudent(@RequestBody Customer customer) {
        List<Customer> list=customerService.checkmailID(customer.getEmailId());
        List<Customer> phoneList=customerService.checkPhoneNumber(customer.getPhoneNumber());
        if(list.size()==0) {
            if(phoneList.size()==0) {
                customerService.enterCustomer(customer);
                return "Customer added successfully";
            }
            return "Phone number already exists please use different one ";
        }
        return "Mail id already exists please use different mail id";

    }
    @GetMapping(value="/getAll")
    public List<Customer> getCustomer(){
       return customerService.getCustomer();
    }

    @GetMapping(value = "/getById/{id}")
    public List<Customer> getByID(@PathVariable(value = "id") Long id){
        return customerService.getById(id);
    }

    @PutMapping(value="/sendEmail/{mailId}")
    public String sendEmail(@PathVariable(value = "mailId") String mailId) throws IndexOutOfBoundsException{
        String fromID="otpinvento@gmail.com";
        try{
            List<Customer> list=customerService.checkmailID(mailId);
            Customer customer=list.get(0);
            return otpService.saveOtp(emailSenderService.sendEmail(fromID,customer));

        }
        catch (IndexOutOfBoundsException k){
            return "Email id not registered .Please sign up first";
        }
        catch (Exception e){
            return e.getMessage();
        }


    }


}

