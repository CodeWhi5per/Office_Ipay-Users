package com.IpayUsers.IpayUsers.Service;

import com.IpayUsers.IpayUsers.Dao.UserDao;
import com.IpayUsers.IpayUsers.Domain.User;
import com.IpayUsers.IpayUsers.Dto.UserDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;
    public UserDTO saveUser(UserDTO userDTO){
        userDao.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List <UserDTO> getAllUsers(){
        List<User>userList=userDao.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO updateUser(UserDTO userDTO){
        userDao.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }
    public String deleteUser(@PathVariable int id){
        userDao.deleteById(id);
        return "Deleted Successfully!";
    }
}
