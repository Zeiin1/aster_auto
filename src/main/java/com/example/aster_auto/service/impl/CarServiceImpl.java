package com.example.aster_auto.service.impl;

import com.example.aster_auto.exception.NotFoundException;
import com.example.aster_auto.model.entity.Car;
import com.example.aster_auto.repository.CarRepository;
import com.example.aster_auto.service.CarService;
import com.example.aster_auto.specifications.CarSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> getAllCars(String make, String model, Integer yearStart, Integer yearEnd, BigDecimal priceStart, BigDecimal priceEnd) {
        Specification<Car> spec = Specification.where(CarSpecifications.makeLike(make))
                .and(CarSpecifications.modelLike(model))
                .and(CarSpecifications.yearBetween(yearStart, yearEnd))
                .and(CarSpecifications.priceBetween(priceStart, priceEnd));

        return carRepository.findAll(spec);
    }
    @Override
    public Car getCarById(UUID id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Car not found with id: " + id,HttpStatus.NOT_FOUND));
    }
    @Override
    public Car createCar(Car car) throws BadAttributeValueExpException {
        if(car.getId() !=null)
            throw new BadAttributeValueExpException("Car id must be null");
        return carRepository.save(car);
    }
    @Override
    public Car updateCar(UUID id, Car carDetails) {
        Car car = getCarById(id);
        car.setMake(carDetails.getMake());
        car.setModel(carDetails.getModel());
        car.setYear(carDetails.getYear());
        car.setPrice(carDetails.getPrice());
        car.setVin(carDetails.getVin());
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(UUID id) {
        getCarById(id);
        carRepository.delete(getCarById(id));
    }
}
