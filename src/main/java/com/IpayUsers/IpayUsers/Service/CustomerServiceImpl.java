package com.IpayUsers.IpayUsers.Service;

import com.IpayUsers.IpayUsers.Dao.CustomerDao;
import com.IpayUsers.IpayUsers.Domain.Customer;
import com.IpayUsers.IpayUsers.Dto.CustomerDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO saveCustomer(CustomerDTO customerDTO){
        customerDao.save(modelMapper.map(customerDTO, Customer.class));
        return customerDTO;
    }

    @Override
    public List<Customer>getCustomerByByStatus(String status){
        return customerDao.findByStatus(status);
    }
}
