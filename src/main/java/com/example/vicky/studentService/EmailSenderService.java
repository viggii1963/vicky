package com.example.vicky.studentService;

import com.example.vicky.entity.Customer;
import com.example.vicky.entity.Otp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmailSenderService {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private OtpService otpService;
    public Otp sendEmail(String fromEmail,Customer customer){
        int otp=customerService.getOtp();
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(customer.getEmailId());
        simpleMailMessage.setFrom(fromEmail);
        simpleMailMessage.setSubject("Your OTP has arrived");
        simpleMailMessage.setText("Your OTP is "+otp);
        javaMailSender.send(simpleMailMessage);
        System.out.println("mail send successfully");
        String uuid = UUID.randomUUID().toString();
        if(otpService.check(customer.getCustomerId())){
            Otp otp1= Otp.builder().id(customer.getCustomerId()).otp(otp).localDateTime(LocalDateTime.now()).UUID(uuid).build();
            return otp1;
        }
        List<Otp> otpList=otpService.findById(customer.getCustomerId());
        Otp otp2=otpList.get(0);
        otp2.setOtp(otp);
        otp2.setId(customer.getCustomerId());
        otp2.setLocalDateTime(LocalDateTime.now());
        otp2.setUUID(uuid);
        return otp2;
    }
}
