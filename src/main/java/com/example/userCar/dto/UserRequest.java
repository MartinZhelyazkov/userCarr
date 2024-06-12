package com.example.userCar.dto;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserRequest {

    private String firstName;

    private String lastName;
    @Email
    private String email;

    private String password;
}
