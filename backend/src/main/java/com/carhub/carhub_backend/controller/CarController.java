package com.carhub.carhub_backend.controller;

import com.carhub.carhub_backend.entity.Car;
import com.carhub.carhub_backend.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private CarService carService;

    // POST - Create
    @PostMapping
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {
        Car savedCar = carService.createCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    // GET - All cars
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    // GET - Car by ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    // PUT - Update car by ID
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @Valid @RequestBody Car car) {
        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    // DELETE - Remove car
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id); // call service method
        return ResponseEntity.ok("Car deleted successfully");
    }

}

