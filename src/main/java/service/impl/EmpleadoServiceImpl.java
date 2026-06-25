package service.impl;

import dto.EmpleadoRequestDTO;
import dto.EmpleadoResponseDTO;
import entity.Area;
import entity.Cargo;
import entity.Empleado;
import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AreaRepository;
import repository.CargoRepository;
import repository.EmpleadoRepository;
import service.EmpleadoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final AreaRepository areaRepository;
    private final CargoRepository cargoRepository;

    @Override
    @Transactional
    public EmpleadoResponseDTO create(EmpleadoRequestDTO dto) {
        Area area = areaRepository.findById(dto.getAreaId())
                .orElseThrow(() -> new ResourceNotFoundException("Area not found with id: " + dto.getAreaId()));
        Cargo cargo = cargoRepository.findById(dto.getCargoId())
                .orElseThrow(() -> new ResourceNotFoundException("Cargo not found with id: " + dto.getCargoId()));

        Empleado empleado = new Empleado();
        empleado.setCodigo(dto.getCodigo());
        empleado.setNombres(dto.getNombres());
        empleado.setApellidos(dto.getApellidos());
        empleado.setDni(dto.getDni());
        empleado.setCorreo(dto.getCorreo());
        empleado.setTelefono(dto.getTelefono());
        empleado.setFechaIngreso(dto.getFechaIngreso());
        empleado.setSalarioBase(dto.getSalarioBase());
        empleado.setActivo(true);
        empleado.setArea(area);
        empleado.setCargo(cargo);
        empleado = empleadoRepository.save(empleado);
        return toDto(empleado);
    }

    @Override
    @Transactional
    public EmpleadoResponseDTO update(Long id, EmpleadoRequestDTO dto) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado not found with id: " + id));

        Area area = areaRepository.findById(dto.getAreaId())
                .orElseThrow(() -> new ResourceNotFoundException("Area not found with id: " + dto.getAreaId()));
        Cargo cargo = cargoRepository.findById(dto.getCargoId())
                .orElseThrow(() -> new ResourceNotFoundException("Cargo not found with id: " + dto.getCargoId()));

        empleado.setCodigo(dto.getCodigo());
        empleado.setNombres(dto.getNombres());
        empleado.setApellidos(dto.getApellidos());
        empleado.setDni(dto.getDni());
        empleado.setCorreo(dto.getCorreo());
        empleado.setTelefono(dto.getTelefono());
        empleado.setFechaIngreso(dto.getFechaIngreso());
        empleado.setSalarioBase(dto.getSalarioBase());
        empleado.setArea(area);
        empleado.setCargo(cargo);
        empleado = empleadoRepository.save(empleado);
        return toDto(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmpleadoResponseDTO> findAll() {
        return empleadoRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EmpleadoResponseDTO findById(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado not found with id: " + id));
        return toDto(empleado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado not found with id: " + id));
        empleado.setActivo(false);
        empleadoRepository.save(empleado);
    }

    private EmpleadoResponseDTO toDto(Empleado empleado) {
        return new EmpleadoResponseDTO(
                empleado.getId(),
                empleado.getCodigo(),
                empleado.getNombres(),
                empleado.getApellidos(),
                empleado.getDni(),
                empleado.getCorreo(),
                empleado.getTelefono(),
                empleado.getFechaIngreso(),
                empleado.getSalarioBase(),
                empleado.getActivo(),
                empleado.getArea() != null ? empleado.getArea().getNombre() : null,
                empleado.getCargo() != null ? empleado.getCargo().getNombre() : null
        );
    }
}
