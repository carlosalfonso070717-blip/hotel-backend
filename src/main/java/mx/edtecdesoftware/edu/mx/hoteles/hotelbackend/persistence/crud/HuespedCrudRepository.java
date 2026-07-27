package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.crud;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Huesped;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HuespedCrudRepository extends CrudRepository<Huesped, Integer> {
    Optional<Huesped> findByCorreo(String correo);
}