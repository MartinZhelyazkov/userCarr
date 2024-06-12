package com.example.userCar.service;
import com.example.userCar.converter.CarConverter;
import com.example.userCar.dto.CarRequest;
import com.example.userCar.dto.CarResponse;
import com.example.userCar.model.Car;
import com.example.userCar.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class CarServiceImpl implements CarService{
    private final CarConverter carConverter;
    private final CarRepository carRepository;
    @Autowired
    public CarServiceImpl(CarConverter carConverter, CarRepository carRepository) {
        this.carConverter = carConverter;
        this.carRepository = carRepository;
    }

    @Override
    public CarResponse addCar(CarRequest carRequest) {
        Car car = carConverter.toCar(carRequest);
        Car savedCar = carRepository.save(car);
        CarResponse carResponse = new CarResponse();
        BeanUtils.copyProperties(savedCar,carResponse);
        return carResponse;
    }

    @Override
    public CarResponse findCarById(Long id) {
        Car car = carRepository.getReferenceById(id);
        CarResponse carResponse = new CarResponse();

        BeanUtils.copyProperties(car,carResponse);
        return carResponse;
    }

    @Override
    public void delCarByID(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car updateCarById(CarRequest carRequest, Long id) {
        Optional<Car> existingCar = carRepository.findById(id);
        if (existingCar.isEmpty()) {
            return new Car();
        }
        Car car = existingCar.get();
        if(carRequest.getModel()!=null) {
            car.setModel(carRequest.getModel());
        }
        if(carRequest.getBrand()!=null) {
            car.setBrand(carRequest.getBrand());
        }
        if(carRequest.getRegNumber()!=null){
        car.setRegNumber(carRequest.getRegNumber());
        }
        if(carRequest.getVin()!=null){
        car.setVin(carRequest.getVin());
        }
        return car;
    }
}
