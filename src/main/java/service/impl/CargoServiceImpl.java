package service.impl;

import dto.CargoDTO;
import entity.Cargo;
import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CargoRepository;
import service.CargoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;

    @Override
    @Transactional
    public CargoDTO create(CargoDTO dto) {
        Cargo cargo = new Cargo();
        cargo.setNombre(dto.getNombre());
        cargo.setDescripcion(dto.getDescripcion());
        cargo = cargoRepository.save(cargo);
        return toDto(cargo);
    }

    @Override
    @Transactional
    public CargoDTO update(Long id, CargoDTO dto) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo not found with id: " + id));
        cargo.setNombre(dto.getNombre());
        cargo.setDescripcion(dto.getDescripcion());
        cargo = cargoRepository.save(cargo);
        return toDto(cargo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CargoDTO> findAll() {
        return cargoRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CargoDTO findById(Long id) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo not found with id: " + id));
        return toDto(cargo);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!cargoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cargo not found with id: " + id);
        }
        cargoRepository.deleteById(id);
    }

    private CargoDTO toDto(Cargo cargo) {
        return new CargoDTO(cargo.getId(), cargo.getNombre(), cargo.getDescripcion());
    }
}
