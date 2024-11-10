package alatoo.car_rent.service;

import alatoo.car_rent.model.entity.User;
import alatoo.car_rent.model.dto.authentication.AuthenticationResponse;
import alatoo.car_rent.model.dto.authentication.LoginRequest;
import alatoo.car_rent.model.dto.authentication.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse login(LoginRequest request);
    User getUserFromToken(String token);
}