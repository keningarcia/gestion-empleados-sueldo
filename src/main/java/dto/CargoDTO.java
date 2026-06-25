package dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
}
