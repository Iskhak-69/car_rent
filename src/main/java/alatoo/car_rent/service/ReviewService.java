package alatoo.car_rent.service;

import alatoo.car_rent.model.dto.review.ReviewResponse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface ReviewService {
    List<ReviewResponse> getAllReviews(UUID carId, int page, int size);
    List<ReviewResponse> makeReview(String token, String comment, UUID carId, int rating);
}