package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.service;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HabitacionDomain;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    @Autowired
    public HabitacionService(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }

    public List<HabitacionDomain> getAll() {
        return habitacionRepository.getAll();
    }

    public Optional<HabitacionDomain> getById(Integer idHabitacion) {
        return habitacionRepository.getHabitacion(idHabitacion);
    }

    public Optional<List<HabitacionDomain>> getByHotel(Integer idHotel) {
        return habitacionRepository.getByHotel(idHotel);
    }

    public HabitacionDomain save(HabitacionDomain habitacion) {
        return habitacionRepository.save(habitacion);
    }

    // PUT: actualiza solo si la habitación existe
    public Optional<HabitacionDomain> update(Integer idHabitacion, HabitacionDomain habitacion) {
        if (getById(idHabitacion).isEmpty()) {
            return Optional.empty();
        }
        habitacion.setIdHabitacion(idHabitacion);
        return Optional.of(habitacionRepository.save(habitacion));
    }

    public boolean delete(Integer idHabitacion) {
        if (getById(idHabitacion).isPresent()) {
            habitacionRepository.delete(idHabitacion);
            return true;
        }
        return false;
    }
}