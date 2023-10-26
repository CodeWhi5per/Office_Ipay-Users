package com.IpayUsers.IpayUsers.Controller;


import com.IpayUsers.IpayUsers.Domain.Customer;
import com.IpayUsers.IpayUsers.Dto.CustomerDTO;
import com.IpayUsers.IpayUsers.Service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;



    @GetMapping
    public ResponseEntity<List<Customer>>getCustomerByStatus(@RequestParam String status){
        List<Customer>customers =customerService.getCustomerByByStatus(status);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/saveCustomer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);

    }

}
