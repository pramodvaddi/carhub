package com.carhub.carhub_backend.service;

import com.carhub.carhub_backend.entity.Car;
import jakarta.validation.Valid;

import java.util.List;

public interface CarService {

    Car saveCar(Car car);

    List<Car> getAllCars();

    Car getCarById(Long id);

    void deleteCar(Long id);

    Car createCar(@Valid Car car);

    Car updateCar(Long id, @Valid Car car);
}
