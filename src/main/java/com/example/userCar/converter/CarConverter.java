package com.example.userCar.converter;
import com.example.userCar.dto.CarRequest;
import com.example.userCar.model.Car;
import org.springframework.stereotype.Component;
@Component
public class CarConverter {
    public Car toCar(CarRequest carRequest){
        Car car = new Car();
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        car.setVin(carRequest.getVin());
        car.setRegNumber(carRequest.getRegNumber());
        return car;
    }
}
