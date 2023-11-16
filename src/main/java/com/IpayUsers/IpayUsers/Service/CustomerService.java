package com.IpayUsers.IpayUsers.Service;

import com.IpayUsers.IpayUsers.Domain.Customer;
import com.IpayUsers.IpayUsers.Domain.Customer_Bank_Account;
import com.IpayUsers.IpayUsers.Dto.CustomerDTO;


import java.util.List;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers() throws Exception;
    String createCustomer(CustomerDTO customerDTO) throws Exception;

    List<Customer_Bank_Account> getActiveBankAccountsByCustomerId(int customerId) throws Exception;

    String updateCustomerStatus(int customerId, String newStatus, String remark) throws Exception;

    List<Customer> getCustomerByByStatus(String status) throws Exception;
}

