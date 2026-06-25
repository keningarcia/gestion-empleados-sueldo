package service;

import dto.CargoDTO;

import java.util.List;

public interface CargoService {
    CargoDTO create(CargoDTO dto);
    CargoDTO update(Long id, CargoDTO dto);
    List<CargoDTO> findAll();
    CargoDTO findById(Long id);
    void delete(Long id);
}
