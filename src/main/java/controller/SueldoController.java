package controller;

import dto.SueldoRequestDTO;
import dto.SueldoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SueldoService;

import java.util.List;

@RestController
@RequestMapping("/api/sueldos")
@RequiredArgsConstructor
public class SueldoController {

    private final SueldoService sueldoService;

    @GetMapping
    public ResponseEntity<List<SueldoResponseDTO>> findAll() {
        return ResponseEntity.ok(sueldoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SueldoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(sueldoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SueldoResponseDTO> create(@Valid @RequestBody SueldoRequestDTO dto) {
        return new ResponseEntity<>(sueldoService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SueldoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SueldoRequestDTO dto) {
        return ResponseEntity.ok(sueldoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sueldoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/empleado/{empleadoId}")
    public ResponseEntity<List<SueldoResponseDTO>> findByEmpleadoId(@PathVariable Long empleadoId) {
        return ResponseEntity.ok(sueldoService.findByEmpleadoId(empleadoId));
    }
}
