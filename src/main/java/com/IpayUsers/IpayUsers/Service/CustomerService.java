package com.IpayUsers.IpayUsers.Service;

import com.IpayUsers.IpayUsers.Domain.Customer;
import com.IpayUsers.IpayUsers.Dto.CustomerDTO;
import com.IpayUsers.IpayUsers.Dto.UserDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);



    List<Customer>getCustomerByByStatus(String status);
}
