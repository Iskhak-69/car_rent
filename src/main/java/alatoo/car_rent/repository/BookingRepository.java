package alatoo.car_rent.repository;

import alatoo.car_rent.model.entity.Booking;
import alatoo.car_rent.model.entity.Car;
import alatoo.car_rent.model.entity.User;
import alatoo.car_rent.model.enums.BookingStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
    List<Booking> findAllByCar(Car car, PageRequest pageRequest);
    List<Booking> findAllByTenant(User tenant, PageRequest pageRequest);
    List<Booking> findAllByStatus(BookingStatus status, PageRequest pageRequest);
}