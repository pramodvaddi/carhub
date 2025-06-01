package com.carhub.carhub_backend.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="carhub")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Make is required")
    @Column(name="Make")
    private String make;

    @NotBlank(message = "Model is required")
    @Column(name="Model")
    private String model;

    @Min(value = 2015, message = "Year Must be after 2015")
    @Column(name="Year")
    private int year;

    @Positive(message = "Price must be greater than $100.00")
    @Column(name="Price")
    private double price;


    // No Args Constructor
    public Car(){

    }

    // Params Constructor
    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
