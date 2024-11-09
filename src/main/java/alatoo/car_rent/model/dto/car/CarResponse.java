package alatoo.car_rent.model.dto.car;

import lombok.Data;
import java.util.List;
import java.time.LocalDate;

@Data
public class CarResponse {
    private String id;
    private String make;
    private Integer year;
    private Double price;
    private String model;
    private String location;
    private LocalDate availableFrom;
    private Double rating;
    private String description;
    private List<String> imagesPaths;
    private List<String> reviews;
}
