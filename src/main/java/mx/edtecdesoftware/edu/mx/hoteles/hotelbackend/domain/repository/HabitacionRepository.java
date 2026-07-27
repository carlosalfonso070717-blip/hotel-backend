package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.repository;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HabitacionDomain;

import java.util.List;
import java.util.Optional;

public interface HabitacionRepository {
    List<HabitacionDomain> getAll();
    Optional<HabitacionDomain> getHabitacion(Integer idHabitacion);
    Optional<List<HabitacionDomain>> getByHotel(Integer idHotel);
    HabitacionDomain save(HabitacionDomain habitacion);
    void delete(Integer idHabitacion);
}