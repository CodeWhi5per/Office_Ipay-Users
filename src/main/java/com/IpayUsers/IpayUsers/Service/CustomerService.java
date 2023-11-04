package com.IpayUsers.IpayUsers.Service;

import com.IpayUsers.IpayUsers.Domain.Customer;
import com.IpayUsers.IpayUsers.Dto.CustomerDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    ResponseEntity<?> createCustomer(CustomerDTO customerDTO);

    ResponseEntity<?> getActiveBankAccountsByCustomerId(int customerId);

    ResponseEntity<?> updateCustomerStatus(int customerId, String newStatus, String remark);

    List<Customer>getCustomerByByStatus(String status);
}
