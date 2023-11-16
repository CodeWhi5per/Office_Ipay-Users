package com.IpayUsers.IpayUsers.Controller;


import com.IpayUsers.IpayUsers.Domain.Customer;
import com.IpayUsers.IpayUsers.Domain.Customer_Bank_Account;
import com.IpayUsers.IpayUsers.Dto.CustomerDTO;
import com.IpayUsers.IpayUsers.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerService.getAllCustomers();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }


    @GetMapping
    public List<Customer> getCustomerByStatus(@RequestParam String status) throws Exception {
        return customerService.getCustomerByByStatus(status);
    }

    @PostMapping("/saveCustomer")
    public String createCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
        return customerService.createCustomer(customerDTO);
    }

    @GetMapping("/{customerId}/activeBankAccounts")
    public List<Customer_Bank_Account> getActiveBankAccountsByCustomerId(@PathVariable int customerId) throws Exception {
        List<Customer_Bank_Account> activeBankAccounts = customerService.getActiveBankAccountsByCustomerId(customerId);
        if (activeBankAccounts.isEmpty()) {
            throw new Exception("No active accounts for this customer");
        }
        return activeBankAccounts;
    }

    @PutMapping("/updateCustomerStatus/{customerId}")
    public String updateCustomerStatus(
            @PathVariable int customerId,
            @RequestParam String newStatus,
            @RequestParam String remark
    ) throws Exception {
        return customerService.updateCustomerStatus(customerId, newStatus, remark);
    }
}
