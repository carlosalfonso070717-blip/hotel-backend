package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Reserva;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository<Reserva, Integer> {
}