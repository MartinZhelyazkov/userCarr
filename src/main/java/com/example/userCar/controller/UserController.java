package com.example.userCar.controller;
import com.example.userCar.dto.UserRequest;
import com.example.userCar.dto.UserResponse;
import com.example.userCar.model.User;
import com.example.userCar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/u1/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
     ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) throws Exception {
        return new ResponseEntity<UserResponse>(userService.addUser(userRequest),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
     ResponseEntity<UserResponse> getUserById(@PathVariable("id")Long id){
        return new ResponseEntity<UserResponse>(userService.getUserById(id),HttpStatus.FOUND);
    }
    @DeleteMapping("/{userId}")
    void delUserID(@PathVariable("userId")Long id){
        userService.delUserID(id);
    }
    @PostMapping("/{userId}")
    ResponseEntity<User> updateUser(@PathVariable("userId")Long id,@RequestBody UserRequest userRequest){
        User updatedUser = userService.updateUser(id,userRequest);
        return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
    }
}
