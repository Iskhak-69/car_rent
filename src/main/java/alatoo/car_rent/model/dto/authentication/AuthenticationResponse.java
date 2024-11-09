package alatoo.car_rent.model.dto.authentication;

import alatoo.car_rent.model.enums.Roles;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String token;
    private Roles role;
}
