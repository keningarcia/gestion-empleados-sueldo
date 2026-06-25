package controller;

import dto.EmpleadoRequestDTO;
import dto.EmpleadoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> findAll() {
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> create(@Valid @RequestBody EmpleadoRequestDTO dto) {
        return new ResponseEntity<>(empleadoService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EmpleadoRequestDTO dto) {
        return ResponseEntity.ok(empleadoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
