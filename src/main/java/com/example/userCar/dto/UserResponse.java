package com.example.userCar.dto;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserResponse {
    private Long id;

    private String firstName;

    private String lastName;
    @Email
    private String email;

}
