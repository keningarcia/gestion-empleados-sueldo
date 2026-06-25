package controller;

import dto.DetalleSueldoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.DetalleSueldoService;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-sueldos")
@RequiredArgsConstructor
public class DetalleSueldoController {

    private final DetalleSueldoService detalleSueldoService;

    @GetMapping("/sueldo/{sueldoId}")
    public ResponseEntity<List<DetalleSueldoDTO>> findBySueldoId(@PathVariable Long sueldoId) {
        return ResponseEntity.ok(detalleSueldoService.findBySueldoId(sueldoId));
    }
}
