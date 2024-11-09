package alatoo.car_rent.model.entity;

import alatoo.car_rent.model.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "booking_table")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private double price;
    private BookingStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    private User tenant;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}