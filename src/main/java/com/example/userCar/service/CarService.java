package com.example.userCar.service;
import com.example.userCar.dto.CarRequest;
import com.example.userCar.dto.CarResponse;
import com.example.userCar.model.Car;
public interface CarService {
    CarResponse addCar(CarRequest carRequest);
    CarResponse findCarById(Long id);
    void delCarByID(Long id);
    Car updateCarById(CarRequest carRequest, Long id);
}
