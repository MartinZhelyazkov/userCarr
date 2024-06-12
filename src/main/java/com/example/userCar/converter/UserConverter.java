package com.example.userCar.converter;
import com.example.userCar.dto.UserRequest;
import com.example.userCar.model.User;
import org.springframework.stereotype.Component;
@Component
public class UserConverter {
    public User toUser(UserRequest userRequest){
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return user;
    }
}
