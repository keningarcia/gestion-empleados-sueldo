package mapper;

import dto.EmpleadoRequestDTO;
import dto.EmpleadoResponseDTO;
import entity.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    @Mapping(target = "areaNombre", expression = "java(empleado.getArea() != null ? empleado.getArea().getNombre() : null)")
    @Mapping(target = "cargoNombre", expression = "java(empleado.getCargo() != null ? empleado.getCargo().getNombre() : null)")
    EmpleadoResponseDTO toResponseDto(Empleado empleado);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", constant = "true")
    @Mapping(target = "area", ignore = true)
    @Mapping(target = "cargo", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "sueldos", ignore = true)
    Empleado toEntity(EmpleadoRequestDTO dto);
}
