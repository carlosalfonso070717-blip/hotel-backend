package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.mapper;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HuespedDomain;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Huesped;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HuespedMapper {

    HuespedDomain toDomain(Huesped entity);

    Huesped toEntity(HuespedDomain domain);
}