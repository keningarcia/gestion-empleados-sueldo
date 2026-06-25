package dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SueldoRequestDTO {
    @NotNull
    private Long empleadoId;
    @NotNull
    private LocalDate fechaPago;
    @NotNull
    private BigDecimal salarioBase;
    private List<DetalleSueldoDTO> detalles;
}
