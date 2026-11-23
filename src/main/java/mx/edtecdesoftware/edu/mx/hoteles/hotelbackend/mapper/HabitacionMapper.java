package mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.mapper;

import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.domain.HabitacionDomain;
import mx.edtecdesoftware.edu.mx.hoteles.hotelbackend.persistence.entity.Habitacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HabitacionMapper {

    @Mapping(target = "idHotel", source = "idHotel")
    @Mapping(target = "imageUrl", source = "imageUrl")
    HabitacionDomain toDomain(Habitacion entity);

    @Mapping(target = "hotel", ignore = true)
    @Mapping(target = "imageUrl", source = "imageUrl")
    Habitacion toEntity(HabitacionDomain domain);
}