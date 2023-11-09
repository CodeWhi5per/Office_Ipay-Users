package com.IpayUsers.IpayUsers.Controller;


import com.IpayUsers.IpayUsers.Domain.Customer;
import com.IpayUsers.IpayUsers.Domain.Customer_Bank_Account;
import com.IpayUsers.IpayUsers.Dto.CustomerDTO;
import com.IpayUsers.IpayUsers.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomerByStatus(@RequestParam String status) {
        return customerService.getCustomerByByStatus(status);
    }

    @PostMapping("/saveCustomer")
    public String createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @GetMapping("/{customerId}/activeBankAccounts")
    public List<Customer_Bank_Account> getActiveBankAccountsByCustomerId(@PathVariable int customerId) {
        List<Customer_Bank_Account> activeBankAccounts = customerService.getActiveBankAccountsByCustomerId(customerId);
        if (activeBankAccounts.isEmpty()) {

        }
        return activeBankAccounts;
    }

    @PutMapping("/updateCustomerStatus/{customerId}")
    public String updateCustomerStatus(
            @PathVariable int customerId,
            @RequestParam String newStatus,
            @RequestParam String remark
    ) {
        return customerService.updateCustomerStatus(customerId, newStatus, remark);
    }
}
