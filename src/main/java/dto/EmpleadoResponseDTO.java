package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoResponseDTO {
    private Long id;
    private String codigo;
    private String nombres;
    private String apellidos;
    private String dni;
    private String correo;
    private String telefono;
    private LocalDate fechaIngreso;
    private BigDecimal salarioBase;
    private Boolean activo;
    private String areaNombre;
    private String cargoNombre;
}
