package com.IpayUsers.IpayUsers.Controller;


import com.IpayUsers.IpayUsers.Domain.Customer;
import com.IpayUsers.IpayUsers.Dto.CustomerDTO;
import com.IpayUsers.IpayUsers.Service.CustomerService;
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
    private CustomerService customerService;



    @GetMapping
    public ResponseEntity<List<Customer>>getCustomerByStatus(@RequestParam String status){
        List<Customer>customers =customerService.getCustomerByByStatus(status);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO) {
        ResponseEntity<?> response = customerService.createCustomer(customerDTO);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response;
        } else {
            return ResponseEntity.status(response.getStatusCode()).body("Error: " + response.getBody());
        }
    }

    @GetMapping("/{customerId}/activeBankAccounts")
    public ResponseEntity<?> getActiveBankAccountsByCustomerId(@PathVariable int customerId) {
        ResponseEntity<?> response = customerService.getActiveBankAccountsByCustomerId(customerId);

        if (response.getBody() == null) {
            return ResponseEntity.notFound().build();
        }

        return response;
    }


    @PutMapping("/updateCustomerStatus/{customerId}")
    public ResponseEntity<?> updateCustomerStatus(
            @PathVariable int customerId,
            @RequestParam String newStatus,
            @RequestParam String remark
    ) {
        ResponseEntity<?> response = customerService.updateCustomerStatus(customerId, newStatus, remark);

        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Customer status updated successfully");
        } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.notFound().build();
        } else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
            return ResponseEntity.badRequest().body("Error: " + response.getBody());
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }



}
