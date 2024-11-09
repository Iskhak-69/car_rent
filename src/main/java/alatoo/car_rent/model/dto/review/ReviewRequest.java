package alatoo.car_rent.model.dto.review;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewRequest {
    @NotBlank(message = "Comment can't be empty or consist only of spaces")
    private String comment;
}
