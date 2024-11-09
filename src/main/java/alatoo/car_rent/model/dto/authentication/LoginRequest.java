package alatoo.car_rent.model.dto.authentication;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginRequest {
    @Email(message = "Incorrect email")
    private String email;

    @NotBlank(message = "Password can't be empty or consist only of spaces")
    @Size(min = 2, max = 15, message = "Password length must be from 2 to 15 characters")
    private String password;
}
