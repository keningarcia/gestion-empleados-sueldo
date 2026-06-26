package mapper;

import dto.SueldoRequestDTO;
import dto.SueldoResponseDTO;
import entity.Sueldo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DetalleSueldoMapper.class})
public interface SueldoMapper {

    @Mapping(target = "empleadoNombre", expression = "java(sueldo.getEmpleado() != null ? sueldo.getEmpleado().getNombres() + \" \" + sueldo.getEmpleado().getApellidos() : null)")
    SueldoResponseDTO toResponseDto(Sueldo sueldo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "empleado", ignore = true)
    @Mapping(target = "totalBonificaciones", ignore = true)
    @Mapping(target = "totalDescuentos", ignore = true)
    @Mapping(target = "salarioNeto", ignore = true)
    Sueldo toEntity(SueldoRequestDTO dto);
}
