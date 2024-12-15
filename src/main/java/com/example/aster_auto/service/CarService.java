package com.example.aster_auto.service;

import com.example.aster_auto.model.entity.Car;

import javax.management.BadAttributeValueExpException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface CarService {
    List<Car> getAllCars(String make, String model, Integer yearStart, Integer yearEnd, BigDecimal priceStart, BigDecimal priceEnd);

    Car getCarById(UUID id);

    Car createCar(Car car) throws BadAttributeValueExpException;

    Car updateCar(UUID id, Car carDetails);

    void deleteCar(UUID id);
}
