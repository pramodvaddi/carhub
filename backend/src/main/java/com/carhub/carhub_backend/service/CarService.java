package com.carhub.carhub_backend.service;

import com.carhub.carhub_backend.entity.Car;

import java.util.List;

public interface CarService {

    Car saveCar(Car car);

    List<Car> getAllCars();

    Car getCarById(Long id);

    void deleteCar(Long id);

}
