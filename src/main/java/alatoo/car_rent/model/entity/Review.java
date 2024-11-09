package alatoo.car_rent.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private double rating;
    private int countRatings;
    private String comments;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "reviewer_id", referencedColumnName = "id")
    private User reviewer;
}