package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HabitacionDomain;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.repository.HabitacionRepository;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.mapper.HabitacionMapper;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.crud.HabitacionCrudRepository;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Habitacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HabitacionRepositoryImpl implements HabitacionRepository {

    @Autowired
    private HabitacionCrudRepository habitacionCrudRepository;
    @Autowired
    private HabitacionMapper habitacionMapper;

    @Override
    public List<HabitacionDomain> getAll() {
        List<HabitacionDomain> resultado = new ArrayList<>();
        Iterable<Habitacion> habitaciones = habitacionCrudRepository.findAll();
        for (Habitacion habitacion : habitaciones) {
            resultado.add(habitacionMapper.toDomain(habitacion));
        }
        return resultado;
    }

    @Override
    public Optional<HabitacionDomain> getHabitacion(Integer idHabitacion) {
        Optional<Habitacion> encontrada = habitacionCrudRepository.findById(idHabitacion);
        if (encontrada.isPresent()) {
            return Optional.of(habitacionMapper.toDomain(encontrada.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<HabitacionDomain>> getByHotel(Integer idHotel) {
        List<Habitacion> habitaciones = habitacionCrudRepository.findByIdHotel(idHotel);
        List<HabitacionDomain> resultado = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            resultado.add(habitacionMapper.toDomain(habitacion));
        }
        return Optional.of(resultado);
    }

    @Override
    public HabitacionDomain save(HabitacionDomain habitacion) {
        Habitacion entidad = habitacionMapper.toEntity(habitacion);
        Habitacion guardada = habitacionCrudRepository.save(entidad);
        return habitacionMapper.toDomain(guardada);
    }

    @Override
    public void delete(Integer idHabitacion) {
        habitacionCrudRepository.deleteById(idHabitacion);
    }
}