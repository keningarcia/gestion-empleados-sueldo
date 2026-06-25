package service.impl;

import dto.DetalleSueldoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.DetalleSueldoRepository;
import service.DetalleSueldoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleSueldoServiceImpl implements DetalleSueldoService {

    private final DetalleSueldoRepository detalleSueldoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DetalleSueldoDTO> findBySueldoId(Long sueldoId) {
        return detalleSueldoRepository.findByNominaId(sueldoId).stream()
                .map(d -> new DetalleSueldoDTO(d.getId(), d.getConcepto(), d.getTipo(), d.getMonto()))
                .toList();
    }
}
