package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Huesped;
import org.springframework.data.repository.CrudRepository;

public interface HuespedRepository extends CrudRepository<Huesped, Integer> {
}