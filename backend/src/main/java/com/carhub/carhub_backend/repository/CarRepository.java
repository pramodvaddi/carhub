package com.carhub.carhub_backend.repository;

import com.carhub.carhub_backend.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    //JpaRepository<Car, Long> gives you all basic CRUD operations automatically.
}
