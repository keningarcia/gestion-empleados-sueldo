package controller;

import dto.CargoDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CargoService;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<CargoDTO>> findAll() {
        return ResponseEntity.ok(cargoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cargoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CargoDTO> create(@Valid @RequestBody CargoDTO dto) {
        return new ResponseEntity<>(cargoService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoDTO> update(@PathVariable Long id, @Valid @RequestBody CargoDTO dto) {
        return ResponseEntity.ok(cargoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cargoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
