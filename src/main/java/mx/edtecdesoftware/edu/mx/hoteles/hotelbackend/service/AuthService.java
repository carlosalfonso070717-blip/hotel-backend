package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.service;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HuespedDomain;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository.HuespedRepository;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final HuespedRepository huespedRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(HuespedRepository huespedRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.huespedRepository = huespedRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Optional<String> login(String correo, String contrasenaPlano) {
        Optional<HuespedDomain> encontrado = huespedRepository.getByCorreo(correo);
        if (encontrado.isPresent()) {
            HuespedDomain huesped = encontrado.get();
            if (passwordEncoder.matches(contrasenaPlano, huesped.getContrasena())) {
                String token = jwtUtil.generateToken(huesped.getCorreo());
                return Optional.of(token);
            }
        }
        return Optional.empty();
    }
}