package com.carhub.carhub_backend.controller;

import com.carhub.carhub_backend.entity.Car;
import com.carhub.carhub_backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // POST: Create new car
    @PostMapping
    public Car saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    // GET: Get all cars
    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    // GET: Get car by id
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id){
        return carService.getCarById(id);

    }

    // PUT: Update car
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        Car existingCar = carService.getCarById(id);
        if (existingCar != null) {
            existingCar.setMake(updatedCar.getMake());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setYear(updatedCar.getYear());
            return carService.saveCar(existingCar);
        } else {
            return null; // Will handle better in Day 6 with exception handling
        }
    }

    // DELETE: Delete Car
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }







}
