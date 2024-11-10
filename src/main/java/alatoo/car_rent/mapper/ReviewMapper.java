package alatoo.car_rent.mapper;

import alatoo.car_rent.model.entity.Car;
import alatoo.car_rent.model.entity.Review;
import alatoo.car_rent.model.entity.User;
import alatoo.car_rent.model.dto.review.ReviewRequest;
import alatoo.car_rent.model.dto.review.ReviewResponse;
import java.util.List;

public interface ReviewMapper {
    ReviewResponse toResponse(Review review);
    List<ReviewResponse> toResponseList(List<Review> reviews);
    Review toReview(String comment, int rating, Car car, User reviewer);
}
