package service.impl;

import dto.AreaDTO;
import entity.Area;
import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AreaRepository;
import service.AreaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    @Override
    @Transactional
    public AreaDTO create(AreaDTO dto) {
        Area area = new Area();
        area.setNombre(dto.getNombre());
        area.setDescripcion(dto.getDescripcion());
        area = areaRepository.save(area);
        return toDto(area);
    }

    @Override
    @Transactional
    public AreaDTO update(Long id, AreaDTO dto) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Area not found with id: " + id));
        area.setNombre(dto.getNombre());
        area.setDescripcion(dto.getDescripcion());
        area = areaRepository.save(area);
        return toDto(area);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AreaDTO> findAll() {
        return areaRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AreaDTO findById(Long id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Area not found with id: " + id));
        return toDto(area);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!areaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Area not found with id: " + id);
        }
        areaRepository.deleteById(id);
    }

    private AreaDTO toDto(Area area) {
        return new AreaDTO(area.getId(), area.getNombre(), area.getDescripcion());
    }
}
