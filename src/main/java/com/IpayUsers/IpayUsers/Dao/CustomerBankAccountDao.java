package com.IpayUsers.IpayUsers.Dao;

import com.IpayUsers.IpayUsers.Domain.Customer_Bank_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerBankAccountDao extends JpaRepository<Customer_Bank_Account, Integer> {
}
