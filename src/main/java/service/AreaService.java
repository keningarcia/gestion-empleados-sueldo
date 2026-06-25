package service;

import dto.AreaDTO;

import java.util.List;

public interface AreaService {
    AreaDTO create(AreaDTO dto);
    AreaDTO update(Long id, AreaDTO dto);
    List<AreaDTO> findAll();
    AreaDTO findById(Long id);
    void delete(Long id);
}
