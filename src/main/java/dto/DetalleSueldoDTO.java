package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleSueldoDTO {
    private Long id;
    @NotBlank
    private String concepto;
    @NotBlank
    private String tipo;
    @NotNull
    private BigDecimal monto;
}
