package alatoo.car_rent.service.Implements;

import alatoo.car_rent.config.JwtTokenService;
import alatoo.car_rent.exception.CustomException;
import alatoo.car_rent.mapper.AuthenticationMapper;
import alatoo.car_rent.model.entity.User;
import alatoo.car_rent.model.dto.authentication.AuthenticationResponse;
import alatoo.car_rent.model.dto.authentication.LoginRequest;
import alatoo.car_rent.model.dto.authentication.RegisterRequest;
import alatoo.car_rent.repository.UserRepository;
import alatoo.car_rent.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationMapper authenticationMapper;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new CustomException("Email already exists!", HttpStatus.FOUND);
        }
        User user = authenticationMapper.toUser(request);
        User savedUser = userRepository.save(user);
        String token = jwtTokenService.generateJwtToken(savedUser);
        return new AuthenticationResponse("User registered successfully", token);
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException("Email not found!", HttpStatus.NOT_FOUND));
        String token = jwtTokenService.generateJwtToken(user);
        return new AuthenticationResponse("Login successful", token);
    }

    @Override
    public User getUserFromToken(String token) {
        token = token.substring(7);
        String userEmail = jwtTokenService.extractUserEmailFromToken(token);
        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new CustomException("Email not found!", HttpStatus.NOT_FOUND));
    }
}
