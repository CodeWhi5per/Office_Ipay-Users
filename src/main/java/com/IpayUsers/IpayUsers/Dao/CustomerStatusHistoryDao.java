package com.IpayUsers.IpayUsers.Dao;

import com.IpayUsers.IpayUsers.Domain.CustomerStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerStatusHistoryDao extends JpaRepository<CustomerStatusHistory, Integer> {

}
