package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HotelDomain;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.mapper.HotelMapper;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.crud.HotelCrudRepository;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Hotel;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HotelRepositoryImpl implements HotelRepository {

    @Autowired
    private HotelCrudRepository hotelCrudRepository;
    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public List<HotelDomain> getAll() {
        List<HotelDomain> resultado = new ArrayList<>();
        Iterable<Hotel> hoteles = hotelCrudRepository.findAll();
        for (Hotel hotel : hoteles) {
            resultado.add(hotelMapper.toDomain(hotel));
        }
        return resultado;
    }

    @Override
    public Optional<HotelDomain> getHotel(Integer idHotel) {
        Optional<Hotel> encontrado = hotelCrudRepository.findById(idHotel);
        if (encontrado.isPresent()) {
            return Optional.of(hotelMapper.toDomain(encontrado.get()));
        }
        return Optional.empty();
    }

    @Override
    public HotelDomain save(HotelDomain hotel) {
        Hotel entidad = hotelMapper.toEntity(hotel);
        Hotel guardado = hotelCrudRepository.save(entidad);
        return hotelMapper.toDomain(guardado);
    }

    @Override
    public void delete(Integer idHotel) {
        hotelCrudRepository.deleteById(idHotel);
    }
}