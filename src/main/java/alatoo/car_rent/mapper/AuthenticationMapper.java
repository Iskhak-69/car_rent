package alatoo.car_rent.mapper;

import alatoo.car_rent.model.entity.User;
import alatoo.car_rent.model.dto.authentication.AuthenticationResponse;
import alatoo.car_rent.model.dto.authentication.RegisterRequest;

public interface AuthenticationMapper {
    AuthenticationResponse toAuthResponse(User user);
    User toUser(RegisterRequest request);
}