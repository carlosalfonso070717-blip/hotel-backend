package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.mapper;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HotelDomain;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelDomain toDomain(Hotel entity);

    @Mapping(target = "habitaciones", ignore = true)
    Hotel toEntity(HotelDomain domain);
}