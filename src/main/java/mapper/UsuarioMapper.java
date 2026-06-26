package mapper;

import dto.UsuarioDTO;
import entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "rol", expression = "java(usuario.getRol().name())")
    @Mapping(target = "empleadoId", expression = "java(usuario.getEmpleado() != null ? usuario.getEmpleado().getId() : null)")
    UsuarioDTO toDto(Usuario usuario);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rol", ignore = true)
    @Mapping(target = "empleado", ignore = true)
    Usuario toEntity(UsuarioDTO dto);
}
