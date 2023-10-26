package com.IpayUsers.IpayUsers.Dao;

import com.IpayUsers.IpayUsers.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
    List<Customer>findByStatus(String status);
}
