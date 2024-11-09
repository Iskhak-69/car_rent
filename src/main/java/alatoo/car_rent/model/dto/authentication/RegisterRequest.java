package alatoo.car_rent.model.dto.authentication;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class RegisterRequest {
    @Size(min = 2, max = 24, message = "Size: min = 2, max = 24")
    @NotBlank(message = "Name can't be empty or consist only of spaces")
    private String name;
    @Email(message = "Incorrect email")
    private String email;
    @NotBlank(message = "Password can't be empty or consist ony of spaces")
    @Size(min = 2, max = 15, message = "Password length must be from 2 to 15 characters")
    private String password;
    @NotBlank(message = "Role can't be empty or consist only of spaces")
    private String role;
    @NotBlank(message = "Phone can't be empty or consist only of spaces")
    private String phone;
}