package dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoRequestDTO {
    @NotBlank
    private String codigo;
    @NotBlank
    private String nombres;
    @NotBlank
    private String apellidos;
    @NotBlank
    private String dni;
    @NotBlank
    @Email
    private String correo;
    @NotBlank
    private String telefono;
    @NotNull
    private LocalDate fechaIngreso;
    @NotNull
    private BigDecimal salarioBase;
    @NotNull
    private Long areaId;
    @NotNull
    private Long cargoId;
}
