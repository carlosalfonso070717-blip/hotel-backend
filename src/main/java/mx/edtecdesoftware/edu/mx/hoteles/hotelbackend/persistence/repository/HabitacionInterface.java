package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Habitacion;
import org.springframework.data.repository.CrudRepository;

public interface HabitacionInterface extends CrudRepository<Habitacion, Integer> {
}
