package com.example.userCar.service;
import com.example.userCar.converter.UserConverter;
import com.example.userCar.dto.UserRequest;
import com.example.userCar.dto.UserResponse;
import com.example.userCar.model.User;
import com.example.userCar.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) throws Exception {
        User user = userConverter.toUser(userRequest);
        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw new Exception("Try again with different email");
        }
        User savedUser = userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(savedUser,userResponse);
        return userResponse;
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).get();
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user,userResponse);
        return userResponse;
    }

    @Override
    public void delUserID(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, UserRequest userRequest) {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isEmpty())
            return new User();
        User user = existingUser.get();
        if(user.getFirstName()!=null){
            user.setFirstName(userRequest.getFirstName());
        }if(user.getLastName()!=null){
            user.setLastName(userRequest.getLastName());
        }if(user.getEmail()!=null){
            user.setEmail(userRequest.getEmail());
        }if(user.getPassword()!=null){
            user.setPassword(userRequest.getPassword());
        }
        return user;
    }
}
