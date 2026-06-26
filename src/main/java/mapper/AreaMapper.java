package mapper;

import dto.AreaDTO;
import entity.Area;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AreaMapper {

    AreaDTO toDto(Area area);

    Area toEntity(AreaDTO dto);
}
