package alatoo.car_rent.repository;

import alatoo.car_rent.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID>, JpaSpecificationExecutor<Car> {
}
