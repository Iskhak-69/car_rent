package alatoo.car_rent.model.dto.review;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReviewResponse {
    private String comment;
    private String reviewer;
    private double rating;
    private LocalDateTime createdAt;
}