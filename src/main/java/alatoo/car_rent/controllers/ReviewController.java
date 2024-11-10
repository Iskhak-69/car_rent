package alatoo.car_rent.controllers;

import alatoo.car_rent.model.dto.review.ReviewResponse;
import alatoo.car_rent.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{carId}")
    public List<ReviewResponse> getReviewsForCar(
            @PathVariable UUID carId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        // Получаем список всех отзывов для конкретного автомобиля с учетом пагинации
        return reviewService.getAllReviews(carId, page, size);
    }

    @PostMapping("/make/{carId}")
    public List<ReviewResponse> addReviewForCar(
            @RequestHeader("Authorization") String token,
            @PathVariable UUID carId,
            @RequestParam(required = false) String comment,
            @RequestParam(required = false, defaultValue = "0") int rating
    ) {
        // Добавляем новый отзыв для автомобиля
        return reviewService.makeReview(token, comment, carId, rating);
    }
}
