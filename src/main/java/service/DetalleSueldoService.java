package service;

import dto.DetalleSueldoDTO;

import java.util.List;

public interface DetalleSueldoService {
    List<DetalleSueldoDTO> findBySueldoId(Long sueldoId);
}
