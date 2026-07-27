package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.service;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HotelDomain;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDomain> getAll() {
        return hotelRepository.getAll();
    }

    public Optional<HotelDomain> getById(Integer idHotel) {
        return hotelRepository.getHotel(idHotel);
    }

    public HotelDomain save(HotelDomain hotel) {
        return hotelRepository.save(hotel);
    }

    public boolean delete(Integer idHotel) {
        if (getById(idHotel).isPresent()) {
            hotelRepository.delete(idHotel);
            return true;
        }
        return false;
    }
}