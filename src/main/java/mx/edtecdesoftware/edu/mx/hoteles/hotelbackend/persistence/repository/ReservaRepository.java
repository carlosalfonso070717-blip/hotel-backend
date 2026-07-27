package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.ReservaDomain;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository {
    List<ReservaDomain> getAll();
    Optional<ReservaDomain> getReserva(Integer idReserva);
    Optional<List<ReservaDomain>> getByHuesped(Integer idHuesped);
    Optional<List<ReservaDomain>> getByHabitacion(Integer idHabitacion);
    ReservaDomain save(ReservaDomain reserva);
    void delete(Integer idReserva);
}