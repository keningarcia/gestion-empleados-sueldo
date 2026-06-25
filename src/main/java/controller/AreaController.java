package controller;

import dto.AreaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AreaService;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @GetMapping
    public ResponseEntity<List<AreaDTO>> findAll() {
        return ResponseEntity.ok(areaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(areaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AreaDTO> create(@Valid @RequestBody AreaDTO dto) {
        return new ResponseEntity<>(areaService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaDTO> update(@PathVariable Long id, @Valid @RequestBody AreaDTO dto) {
        return ResponseEntity.ok(areaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        areaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
