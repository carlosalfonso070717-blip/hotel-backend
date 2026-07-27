package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.crud;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Reserva;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservaCrudRepository extends CrudRepository<Reserva, Integer> {
    List<Reserva> findByIdHuesped(Integer idHuesped);
    List<Reserva> findByIdHabitacion(Integer idHabitacion);
}