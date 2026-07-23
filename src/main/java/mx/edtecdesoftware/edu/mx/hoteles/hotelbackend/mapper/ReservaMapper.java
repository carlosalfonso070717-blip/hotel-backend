package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.mapper;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.ReservaDomain;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaDomain toDomain(Reserva entity);

    @Mapping(target = "habitacion", ignore = true)
    @Mapping(target = "huesped", ignore = true)
    Reserva toEntity(ReservaDomain domain);
}