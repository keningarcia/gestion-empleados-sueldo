package entity;

import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class DetalleSueldo {
    private Long id;

    private String concepto;

    private String tipo;

    private BigDecimal monto;

    @ManyToOne
    private Sueldo nomina;
}
