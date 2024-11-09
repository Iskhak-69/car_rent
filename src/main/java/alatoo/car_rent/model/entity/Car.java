package alatoo.car_rent.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "cars_table")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String make;
    private String model;
    private int year;
    private double price;
    private String color;
    private double rating;
    private String description;
    private String location;
    private LocalDate availableFrom;

    @OneToMany(mappedBy = "car")
    private List<Review> reviews;
}