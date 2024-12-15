package com.example.aster_auto.model.entity;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotBlank
    private String make;

    @NotBlank
    private String model;

    @Min(1886)
  //  @Max(Year.now().getValue())
    private int year;

    @Positive
    private BigDecimal price;

    @Size(min = 17, max = 17)
    @NotBlank
    @Column(columnDefinition = "CHAR(17)")
    private String vin;
}
