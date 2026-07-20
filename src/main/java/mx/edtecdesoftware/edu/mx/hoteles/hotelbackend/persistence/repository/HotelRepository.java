package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {
}
