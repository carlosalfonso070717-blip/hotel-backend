package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HuespedDomain;

import java.util.List;
import java.util.Optional;

public interface HuespedRepository {
    List<HuespedDomain> getAll();
    Optional<HuespedDomain> getHuesped(Integer idHuesped);
    Optional<HuespedDomain> getByCorreo(String correo);
    HuespedDomain save(HuespedDomain huesped);
    void delete(Integer idHuesped);
}