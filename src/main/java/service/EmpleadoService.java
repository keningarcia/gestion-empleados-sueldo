package service;

import dto.EmpleadoRequestDTO;
import dto.EmpleadoResponseDTO;

import java.util.List;

public interface EmpleadoService {
    EmpleadoResponseDTO create(EmpleadoRequestDTO dto);
    EmpleadoResponseDTO update(Long id, EmpleadoRequestDTO dto);
    List<EmpleadoResponseDTO> findAll();
    EmpleadoResponseDTO findById(Long id);
    void delete(Long id);
}
