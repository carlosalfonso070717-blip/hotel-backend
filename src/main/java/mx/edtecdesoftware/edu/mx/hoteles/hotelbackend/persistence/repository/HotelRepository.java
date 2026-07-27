package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HotelDomain;

import java.util.List;
import java.util.Optional;

public interface HotelRepository {
    List<HotelDomain> getAll();
    Optional<HotelDomain> getHotel(Integer idHotel);
    HotelDomain save(HotelDomain hotel);
    void delete(Integer idHotel);
}