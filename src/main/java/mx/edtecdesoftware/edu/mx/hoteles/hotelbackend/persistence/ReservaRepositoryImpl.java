package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.ReservaDomain;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.mapper.ReservaMapper;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.crud.ReservaCrudRepository;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Reserva;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepositoryImpl implements ReservaRepository {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;
    @Autowired
    private ReservaMapper reservaMapper;

    @Override
    public List<ReservaDomain> getAll() {
        List<ReservaDomain> resultado = new ArrayList<>();
        Iterable<Reserva> reservas = reservaCrudRepository.findAll();
        for (Reserva reserva : reservas) {
            resultado.add(reservaMapper.toDomain(reserva));
        }
        return resultado;
    }

    @Override
    public Optional<ReservaDomain> getReserva(Integer idReserva) {
        Optional<Reserva> encontrada = reservaCrudRepository.findById(idReserva);
        if (encontrada.isPresent()) {
            return Optional.of(reservaMapper.toDomain(encontrada.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<ReservaDomain>> getByHuesped(Integer idHuesped) {
        List<Reserva> reservas = reservaCrudRepository.findByIdHuesped(idHuesped);
        List<ReservaDomain> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            resultado.add(reservaMapper.toDomain(reserva));
        }
        return Optional.of(resultado);
    }

    @Override
    public Optional<List<ReservaDomain>> getByHabitacion(Integer idHabitacion) {
        List<Reserva> reservas = reservaCrudRepository.findByIdHabitacion(idHabitacion);
        List<ReservaDomain> resultado = new ArrayList<>();
        for (Reserva reserva : reservas) {
            resultado.add(reservaMapper.toDomain(reserva));
        }
        return Optional.of(resultado);
    }

    @Override
    public ReservaDomain save(ReservaDomain reserva) {
        Reserva entidad = reservaMapper.toEntity(reserva);
        Reserva guardada = reservaCrudRepository.save(entidad);
        return reservaMapper.toDomain(guardada);
    }

    @Override
    public void delete(Integer idReserva) {
        reservaCrudRepository.deleteById(idReserva);
    }
}