package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.service;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.ReservaDomain;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaDomain> getAll() {
        return reservaRepository.getAll();
    }

    public Optional<ReservaDomain> getById(Integer idReserva) {
        return reservaRepository.getReserva(idReserva);
    }

    public Optional<List<ReservaDomain>> getByHuesped(Integer idHuesped) {
        return reservaRepository.getByHuesped(idHuesped);
    }

    public Optional<List<ReservaDomain>> getByHabitacion(Integer idHabitacion) {
        return reservaRepository.getByHabitacion(idHabitacion);
    }

    public ReservaDomain save(ReservaDomain reserva) {
        return reservaRepository.save(reserva);
    }

    public boolean delete(Integer idReserva) {
        if (getById(idReserva).isPresent()) {
            reservaRepository.delete(idReserva);
            return true;
        }
        return false;
    }
}