package mapper;

import dto.CargoDTO;
import entity.Cargo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CargoMapper {

    CargoDTO toDto(Cargo cargo);

    Cargo toEntity(CargoDTO dto);
}
