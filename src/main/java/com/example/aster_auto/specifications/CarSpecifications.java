package com.example.aster_auto.specifications;

import com.example.aster_auto.model.entity.Car;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class CarSpecifications {

    public static Specification<Car> makeLike(String make) {
        return (root, query, criteriaBuilder) ->
                make == null ? null : criteriaBuilder.like(root.get("make"), "%" + make + "%");
    }

    public static Specification<Car> modelLike(String model) {
        return (root, query, criteriaBuilder) ->
                model == null ? null : criteriaBuilder.like(root.get("model"), "%" + model + "%");
    }

    public static Specification<Car> yearBetween(Integer yearStart, Integer yearEnd) {
        return (root, query, criteriaBuilder) -> {
            if (yearStart == null && yearEnd == null) {
                return null;
            } else if (yearStart == null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("year"), yearEnd);
            } else if (yearEnd == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("year"), yearStart);
            } else {
                return criteriaBuilder.between(root.get("year"), yearStart, yearEnd);
            }
        };
    }

    public static Specification<Car> priceBetween(BigDecimal priceStart, BigDecimal priceEnd) {
        return (root, query, criteriaBuilder) -> {
            if (priceStart == null && priceEnd == null) {
                return null;
            } else if (priceStart == null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), priceEnd);
            } else if (priceEnd == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), priceStart);
            } else {
                return criteriaBuilder.between(root.get("price"), priceStart, priceEnd);
            }
        };
    }
}