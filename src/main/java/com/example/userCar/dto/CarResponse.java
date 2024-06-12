package com.example.userCar.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CarResponse {
    private Long id;

    private String brand;

    private String model;

    private String vin;

    private String regNumber;
}
