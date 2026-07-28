package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.dto.LoginRequest;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.dto.LoginResponse;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Authentication endpoints.")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Validate credentials and return a JWT token.")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        Optional<String> token = authService.login(loginRequest.getCorreo(), loginRequest.getContrasena());
        if (token.isPresent()) {
            return new ResponseEntity<>(new LoginResponse(token.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}