package mapper;

import dto.DetalleSueldoDTO;
import entity.DetalleSueldo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DetalleSueldoMapper {

    DetalleSueldoDTO toDto(DetalleSueldo detalle);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "nomina", ignore = true)
    DetalleSueldo toEntity(DetalleSueldoDTO dto);
}
