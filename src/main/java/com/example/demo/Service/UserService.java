package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Model.UserModel;
import com.example.demo.Repository.UserRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.constraints.FutureOrPresent;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public UserDTO registerUser(@RequestBody UserDTO userDTO) {
        UserModel userModel = userMapper.map(userDTO);
        userModel = userRepository.save(userModel);
        return userMapper.map(userModel);
    }

    public UserDTO showUserById(Long id){
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(userMapper::map).orElse(null);
    }
    public UserDTO deleteUserById(Long id){
        Optional<UserModel> userModel = userRepository.findById(id);
        if(userModel.isPresent()){
            userRepository.deleteById(id);
            return userMapper.map(userModel.get());
        }else{
            return null;
        }
    }

    public List<UserDTO>  getAllUsers(){
        List<UserModel> userModel = userRepository.findAll();
        return userModel.stream().map(userMapper::map).collect(Collectors.toList());
    }



}
