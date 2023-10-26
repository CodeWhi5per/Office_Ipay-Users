package com.IpayUsers.IpayUsers.Service;

import com.IpayUsers.IpayUsers.Dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO);
    String deleteUser(int id);
}
