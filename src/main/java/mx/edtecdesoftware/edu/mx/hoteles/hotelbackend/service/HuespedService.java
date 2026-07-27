package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.service;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HuespedDomain;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository.HuespedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuespedService {

    private final HuespedRepository huespedRepository;

    @Autowired
    public HuespedService(HuespedRepository huespedRepository) {
        this.huespedRepository = huespedRepository;
    }

    public List<HuespedDomain> getAll() {
        return huespedRepository.getAll();
    }

    public Optional<HuespedDomain> getById(Integer idHuesped) {
        return huespedRepository.getHuesped(idHuesped);
    }

    public Optional<HuespedDomain> getByCorreo(String correo) {
        return huespedRepository.getByCorreo(correo);
    }

    public HuespedDomain save(HuespedDomain huesped) {
        return huespedRepository.save(huesped);
    }

    public boolean delete(Integer idHuesped) {
        if (getById(idHuesped).isPresent()) {
            huespedRepository.delete(idHuesped);
            return true;
        }
        return false;
    }
}