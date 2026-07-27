package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HuespedDomain;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.mapper.HuespedMapper;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.crud.HuespedCrudRepository;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Huesped;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.repository.HuespedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HuespedRepositoryImpl implements HuespedRepository {

    @Autowired
    private HuespedCrudRepository huespedCrudRepository;
    @Autowired
    private HuespedMapper huespedMapper;

    @Override
    public List<HuespedDomain> getAll() {
        List<HuespedDomain> resultado = new ArrayList<>();
        Iterable<Huesped> huespedes = huespedCrudRepository.findAll();
        for (Huesped huesped : huespedes) {
            resultado.add(huespedMapper.toDomain(huesped));
        }
        return resultado;
    }

    @Override
    public Optional<HuespedDomain> getHuesped(Integer idHuesped) {
        Optional<Huesped> encontrado = huespedCrudRepository.findById(idHuesped);
        if (encontrado.isPresent()) {
            return Optional.of(huespedMapper.toDomain(encontrado.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<HuespedDomain> getByCorreo(String correo) {
        Optional<Huesped> encontrado = huespedCrudRepository.findByCorreo(correo);
        if (encontrado.isPresent()) {
            return Optional.of(huespedMapper.toDomain(encontrado.get()));
        }
        return Optional.empty();
    }

    @Override
    public HuespedDomain save(HuespedDomain huesped) {
        Huesped entidad = huespedMapper.toEntity(huesped);
        Huesped guardado = huespedCrudRepository.save(entidad);
        return huespedMapper.toDomain(guardado);
    }

    @Override
    public void delete(Integer idHuesped) {
        huespedCrudRepository.deleteById(idHuesped);
    }
}