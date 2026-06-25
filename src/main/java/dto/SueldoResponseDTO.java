package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SueldoResponseDTO {
    private Long id;
    private LocalDate fechaPago;
    private BigDecimal salarioBase;
    private BigDecimal totalBonificaciones;
    private BigDecimal totalDescuentos;
    private BigDecimal salarioNeto;
    private String empleadoNombre;
    private List<DetalleSueldoDTO> detalles;
}
