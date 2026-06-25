package service.impl;

import dto.DetalleSueldoDTO;
import dto.SueldoRequestDTO;
import dto.SueldoResponseDTO;
import entity.DetalleSueldo;
import entity.Empleado;
import entity.Sueldo;
import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.DetalleSueldoRepository;
import repository.EmpleadoRepository;
import repository.SueldoRepository;
import service.SueldoService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SueldoServiceImpl implements SueldoService {

    private final SueldoRepository sueldoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final DetalleSueldoRepository detalleSueldoRepository;

    @Override
    @Transactional
    public SueldoResponseDTO create(SueldoRequestDTO dto) {
        Empleado empleado = empleadoRepository.findById(dto.getEmpleadoId())
                .orElseThrow(() -> new ResourceNotFoundException("Empleado not found with id: " + dto.getEmpleadoId()));

        Sueldo sueldo = new Sueldo();
        sueldo.setEmpleado(empleado);
        sueldo.setFechaPago(dto.getFechaPago());
        sueldo.setSalarioBase(dto.getSalarioBase());

        BigDecimal totalBonificaciones = BigDecimal.ZERO;
        BigDecimal totalDescuentos = BigDecimal.ZERO;

        if (dto.getDetalles() != null) {
            List<DetalleSueldo> detalles = new ArrayList<>();
            for (DetalleSueldoDTO detDto : dto.getDetalles()) {
                DetalleSueldo detalle = new DetalleSueldo();
                detalle.setConcepto(detDto.getConcepto());
                detalle.setTipo(detDto.getTipo());
                detalle.setMonto(detDto.getMonto());
                detalle.setNomina(sueldo);

                if ("BONIFICACION".equalsIgnoreCase(detDto.getTipo())) {
                    totalBonificaciones = totalBonificaciones.add(detDto.getMonto());
                } else if ("DESCUENTO".equalsIgnoreCase(detDto.getTipo())) {
                    totalDescuentos = totalDescuentos.add(detDto.getMonto());
                }

                detalles.add(detalle);
            }
            sueldo.setDetalles(detalles);
        }

        sueldo.setTotalBonificaciones(totalBonificaciones);
        sueldo.setTotalDescuentos(totalDescuentos);
        sueldo.setSalarioNeto(dto.getSalarioBase().add(totalBonificaciones).subtract(totalDescuentos));

        sueldo = sueldoRepository.save(sueldo);
        return toDto(sueldo);
    }

    @Override
    @Transactional
    public SueldoResponseDTO update(Long id, SueldoRequestDTO dto) {
        Sueldo sueldo = sueldoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sueldo not found with id: " + id));

        Empleado empleado = empleadoRepository.findById(dto.getEmpleadoId())
                .orElseThrow(() -> new ResourceNotFoundException("Empleado not found with id: " + dto.getEmpleadoId()));

        sueldo.setEmpleado(empleado);
        sueldo.setFechaPago(dto.getFechaPago());
        sueldo.setSalarioBase(dto.getSalarioBase());

        if (sueldo.getDetalles() != null) {
            detalleSueldoRepository.deleteAll(sueldo.getDetalles());
        }

        BigDecimal totalBonificaciones = BigDecimal.ZERO;
        BigDecimal totalDescuentos = BigDecimal.ZERO;

        if (dto.getDetalles() != null) {
            List<DetalleSueldo> detalles = new ArrayList<>();
            for (DetalleSueldoDTO detDto : dto.getDetalles()) {
                DetalleSueldo detalle = new DetalleSueldo();
                detalle.setConcepto(detDto.getConcepto());
                detalle.setTipo(detDto.getTipo());
                detalle.setMonto(detDto.getMonto());
                detalle.setNomina(sueldo);

                if ("BONIFICACION".equalsIgnoreCase(detDto.getTipo())) {
                    totalBonificaciones = totalBonificaciones.add(detDto.getMonto());
                } else if ("DESCUENTO".equalsIgnoreCase(detDto.getTipo())) {
                    totalDescuentos = totalDescuentos.add(detDto.getMonto());
                }

                detalles.add(detalle);
            }
            sueldo.setDetalles(detalles);
        }

        sueldo.setTotalBonificaciones(totalBonificaciones);
        sueldo.setTotalDescuentos(totalDescuentos);
        sueldo.setSalarioNeto(dto.getSalarioBase().add(totalBonificaciones).subtract(totalDescuentos));

        sueldo = sueldoRepository.save(sueldo);
        return toDto(sueldo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SueldoResponseDTO> findAll() {
        return sueldoRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public SueldoResponseDTO findById(Long id) {
        Sueldo sueldo = sueldoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sueldo not found with id: " + id));
        return toDto(sueldo);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!sueldoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Sueldo not found with id: " + id);
        }
        sueldoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SueldoResponseDTO> findByEmpleadoId(Long empleadoId) {
        return sueldoRepository.findByEmpleadoId(empleadoId).stream().map(this::toDto).toList();
    }

    private SueldoResponseDTO toDto(Sueldo sueldo) {
        List<DetalleSueldoDTO> detalleDtos = new ArrayList<>();
        if (sueldo.getDetalles() != null) {
            detalleDtos = sueldo.getDetalles().stream().map(d -> new DetalleSueldoDTO(
                    d.getId(), d.getConcepto(), d.getTipo(), d.getMonto()
            )).toList();
        }

        return new SueldoResponseDTO(
                sueldo.getId(),
                sueldo.getFechaPago(),
                sueldo.getSalarioBase(),
                sueldo.getTotalBonificaciones(),
                sueldo.getTotalDescuentos(),
                sueldo.getSalarioNeto(),
                sueldo.getEmpleado() != null ? sueldo.getEmpleado().getNombres() + " " + sueldo.getEmpleado().getApellidos() : null,
                detalleDtos
        );
    }
}
