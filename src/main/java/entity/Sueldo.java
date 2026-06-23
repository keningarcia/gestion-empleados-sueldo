package entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Sueldo {
    private Long id;

    private LocalDate fechaPago;

    private BigDecimal salarioBase;

    private BigDecimal totalBonificaciones;

    private BigDecimal totalDescuentos;

    private BigDecimal salarioNeto;

    @ManyToOne
    private Empleado empleado;

    @OneToMany(mappedBy = "nomina")
    private List<DetalleSueldo> detalles;
}
