package com.IpayUsers.IpayUsers.Service;

import com.IpayUsers.IpayUsers.Domain.Customer;
import com.IpayUsers.IpayUsers.Domain.Customer_Bank_Account;
import com.IpayUsers.IpayUsers.Dto.CustomerDTO;


import java.util.List;

public interface CustomerService {
    String createCustomer(CustomerDTO customerDTO);

    List<Customer_Bank_Account> getActiveBankAccountsByCustomerId(int customerId);

    String updateCustomerStatus(int customerId, String newStatus, String remark);

    List<Customer> getCustomerByByStatus(String status);
}

