package alatoo.car_rent.model.dto.car;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CarRequest {
    @Size(min = 2, max = 15, message = "Size: min = 2, max = 15")
    private String make;
    @Size(min = 2, max = 15, message = "Size: min = 2, max = 15")
    private String model;
    @Size(min = 2, max = 20, message = "Size: min = 2, max = 20")
    private String color;
    @Max(value = 2024, message = "The year can't be greater than 2024")
    private int year;
    @NotBlank(message = "Price can't be empty or consist only of spaces")
    private double price;
    @NotBlank(message = "Location can't be empty or consist only of spaces")
    private String location;
    @FutureOrPresent(message = "Start date must be in the future or present")
    private LocalDate availableFrom;
    @Size(min = 2, max = 999, message = "Description length must be from 2 to 999 characters")
    private String description;
}