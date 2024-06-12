package com.example.userCar.service;
import com.example.userCar.dto.UserRequest;
import com.example.userCar.dto.UserResponse;
import com.example.userCar.model.User;


public interface UserService {
    UserResponse addUser(UserRequest userRequest) throws Exception;
    UserResponse getUserById(Long id);
    void delUserID(Long id);
    User updateUser(Long id, UserRequest userRequest);
}
