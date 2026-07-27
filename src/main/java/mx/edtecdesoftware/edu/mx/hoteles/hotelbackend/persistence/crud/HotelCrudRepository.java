package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.crud;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelCrudRepository extends CrudRepository<Hotel, Integer> {
}