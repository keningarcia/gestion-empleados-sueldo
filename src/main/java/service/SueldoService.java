package service;

import dto.SueldoRequestDTO;
import dto.SueldoResponseDTO;

import java.util.List;

public interface SueldoService {
    SueldoResponseDTO create(SueldoRequestDTO dto);
    SueldoResponseDTO update(Long id, SueldoRequestDTO dto);
    List<SueldoResponseDTO> findAll();
    SueldoResponseDTO findById(Long id);
    void delete(Long id);
    List<SueldoResponseDTO> findByEmpleadoId(Long empleadoId);
}
