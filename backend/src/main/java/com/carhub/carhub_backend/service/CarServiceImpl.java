package com.carhub.carhub_backend.service;

import com.carhub.carhub_backend.entity.Car;
import com.carhub.carhub_backend.exception.CarNotFoundException;
import com.carhub.carhub_backend.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    // Get car by ID
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car with ID " + id + " not found"));
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);

    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        return null;
    }
}
