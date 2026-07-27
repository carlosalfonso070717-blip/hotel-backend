package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.crud;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Habitacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HabitacionCrudRepository extends CrudRepository<Habitacion, Integer> {
    List<Habitacion> findByIdHotel(Integer idHotel);
}