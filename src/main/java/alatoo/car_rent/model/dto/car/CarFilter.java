package alatoo.car_rent.model.dto.car;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
public class CarFilter {
    @Size(min = 2, max = 15, message = "Size: min = 2, max = 15")
    private String make;
    @Size(min = 2, max = 15, message = "Size: min = 2, max = 15")
    private String model;
    @Size(min = 2, max = 20, message = "Size: min = 2, max = 20")
    private String color;
    @Max(value = 2024, message = "The year can't be greater than 2024")
    private Integer year;
    @NotBlank(message = "Location can't be empty or consist only of spaces")
    private String location;
    @NotBlank(message = "Price can't be empty or consist only of spaces")
    private Double price;
    @FutureOrPresent(message = "Start date must be in the future or present")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate availableFrom;
    private Double rating;
}