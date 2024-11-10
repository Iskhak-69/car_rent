package alatoo.car_rent.repository;

import alatoo.car_rent.model.entity.Car;
import alatoo.car_rent.model.entity.Review;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
    List<Review> findByCar(Car car, PageRequest pageRequest);
}
