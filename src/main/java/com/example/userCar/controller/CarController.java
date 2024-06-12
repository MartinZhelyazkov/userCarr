package com.example.userCar.controller;
import com.example.userCar.dto.CarRequest;
import com.example.userCar.dto.CarResponse;
import com.example.userCar.model.Car;
import com.example.userCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/c1/car")
public class CarController {
    @Autowired
    CarService carService;
    @PostMapping
     ResponseEntity<CarResponse> addCar(@RequestBody CarRequest carRequest){
        return new ResponseEntity<CarResponse>(carService.addCar(carRequest), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
     ResponseEntity<CarResponse> findCarByID(@PathVariable("id")Long id){
        return new ResponseEntity<CarResponse>(carService.findCarById(id),HttpStatus.FOUND);
    }
    @DeleteMapping("/{carId}")
    void delCarByID(@PathVariable("carId")Long id){
        carService.delCarByID(id);
    }
    @PostMapping("/{carId}")
    ResponseEntity<Car> updateCarById(@RequestBody CarRequest carRequest, @PathVariable("carId")Long id){
        Car updatedCar = carService.updateCarById(carRequest,id);
        return new ResponseEntity<Car>(updatedCar,HttpStatus.OK);
    }
}
