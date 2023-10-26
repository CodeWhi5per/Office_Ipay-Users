package com.IpayUsers.IpayUsers.Dao;

import com.IpayUsers.IpayUsers.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
