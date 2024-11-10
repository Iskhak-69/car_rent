package alatoo.car_rent.controllers;

import alatoo.car_rent.model.dto.authentication.LoginRequest;
import alatoo.car_rent.model.dto.authentication.RegisterRequest;
import alatoo.car_rent.service.AuthenticationService;
import alatoo.car_rent.model.dto.authentication.AuthenticationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request) {
        AuthenticationResponse response = authenticationService.login(request);
        return "redirect:/pages/home";
    }

   @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest request) {
        AuthenticationResponse response = authenticationService.register(request);
        return "redirect:/pages/home";
    }
}

